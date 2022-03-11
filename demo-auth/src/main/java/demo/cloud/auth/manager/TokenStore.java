package demo.cloud.auth.manager;

import com.github.xiaoymin.knife4j.core.util.StrUtil;
import demo.cloud.common.cache.constant.OauthCacheNames;
import demo.cloud.common.core.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.common.core.api.auth.constant.SysTypeEnum;
import demo.cloud.common.core.common.security.vo.TokenInfoBo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
@RefreshScope
public class TokenStore {

    private final RedisTemplate<Object, Object> redisTemplate;

    private final RedisSerializer<Object> redisSerializer;

    private final StringRedisTemplate stringRedisTemplate;

    public TokenStore(RedisTemplate<Object, Object> redisTemplate, RedisSerializer<Object> redisSerializer,
                      StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisSerializer = redisSerializer;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 将用户的部分信息存储在token中，并返回token信息
     *
     * @param userInfoInToken 用户在token中的信息
     * @return token信息
     */
    public TokenInfoBo storeAccessToken(UserInfoInTokenBo userInfoInToken) {
        TokenInfoBo tokenInfoBo = new TokenInfoBo();
        String accessToken = UUID.randomUUID().toString();
        String refreshToken = UUID.randomUUID().toString();

        tokenInfoBo.setUserInfoInToken(userInfoInToken);
        tokenInfoBo.setExpiresIn(getExpiresIn(userInfoInToken.getSysType()));

        String uidToAccessKeyStr = getUidToAccessKey(getApprovalKey(userInfoInToken));
        String accessKeyStr = getAccessKey(accessToken);
        String refreshToAccessKeyStr = getRefreshToAccessKey(refreshToken);

        // 一个用户会登陆很多次，每次登陆的token都会存在 uid_to_access里面
        // 但是每次保存都会更新这个key的时间，而key里面的token有可能会过期，过期就要移除掉
        List<String> existsAccessTokens = new ArrayList<>();
        // 新的token数据
        existsAccessTokens.add(accessToken + StrUtil.COLON + refreshToken);

        Long size = redisTemplate.opsForSet().size(uidToAccessKeyStr);
        if (size != null && size != 0) {
            List<String> tokenInfoBoList = stringRedisTemplate.opsForSet().pop(uidToAccessKeyStr, size);
            if (tokenInfoBoList != null) {
                for (String accessTokenWithRefreshToken : tokenInfoBoList) {
                    String[] accessTokenWithRefreshTokenArr = accessTokenWithRefreshToken.split(StrUtil.COLON);
                    String accessTokenData = accessTokenWithRefreshTokenArr[0];
                    if (BooleanUtil.isTrue(stringRedisTemplate.hasKey(getAccessKey(accessTokenData)))) {
                        existsAccessTokens.add(accessTokenWithRefreshToken);
                    }
                }
            }
        }

        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {

            long expiresIn = tokenInfoBO.getExpiresIn();

            byte[] uidKey = uidToAccessKeyStr.getBytes(StandardCharsets.UTF_8);
            byte[] refreshKey = refreshToAccessKeyStr.getBytes(StandardCharsets.UTF_8);
            byte[] accessKey = accessKeyStr.getBytes(StandardCharsets.UTF_8);

            for (String existsAccessToken : existsAccessTokens) {
                connection.sAdd(uidKey, existsAccessToken.getBytes(StandardCharsets.UTF_8));
            }

            // 通过uid + sysType 保存access_token，当需要禁用用户的时候，可以根据uid + sysType 禁用用户
            connection.expire(uidKey, expiresIn);

            // 通过refresh_token获取用户的access_token从而刷新token
            connection.setEx(refreshKey, expiresIn, accessToken.getBytes(StandardCharsets.UTF_8));

            // 通过access_token保存用户的租户id，用户id，uid
            connection.setEx(accessKey, expiresIn, Objects.requireNonNull(redisSerializer.serialize(userInfoInToken)));

            return null;
        });

        // 返回给前端是加密的token
        tokenInfoBO.setAccessToken(encryptToken(accessToken, userInfoInToken.getSysType()));
        tokenInfoBO.setRefreshToken(encryptToken(refreshToken, userInfoInToken.getSysType()));

        return tokenInfoBO;
    }

    public String getAccessKey(String accessToken) {
        return OauthCacheNames.ACCESS + accessToken;
    }

    private int getExpiresIn(int sysType) {
        // 3600秒
        int expiresIn = 3600;

        // 普通用户token过期时间 1小时
        if (Objects.equals(sysType, SysTypeEnum.ORDINARY.value())) {
            expiresIn = expiresIn * 24 * 30;
        }
        // 系统管理员的token过期时间 2小时
        if (Objects.equals(sysType, SysTypeEnum.MULTISHOP.value()) || Objects.equals(sysType, SysTypeEnum.PLATFORM.value())) {
            expiresIn = expiresIn * 24 * 30;
        }
        return expiresIn;
    }
}
