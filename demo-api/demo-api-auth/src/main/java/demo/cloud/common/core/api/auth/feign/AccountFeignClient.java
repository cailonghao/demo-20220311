package demo.cloud.common.core.api.auth.feign;

import demo.cloud.common.core.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.common.core.api.auth.vo.TokenInfoVO;
import demo.cloud.common.core.feign.FeignInsideAuthConfig;
import demo.cloud.common.core.response.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "demo-auth",contextId ="account")
public interface AccountFeignClient {

    /**
     * 保存用户信息，生成token，返回前端
     * @param userInfoInTokenBO 账户信息 和社交账号信息
     * @return uid
     */
    @PostMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/storeTokenAndGetVo")
    Resp<TokenInfoVO> storeTokenAndGetVo(@RequestBody UserInfoInTokenBo userInfoInTokenBo);

}
