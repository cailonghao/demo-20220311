package demo.cloud.api.auth.feign;

import demo.cloud.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.api.auth.constant.SysTypeEnum;
import demo.cloud.api.auth.dto.AuthAccountDto;
import demo.cloud.api.auth.vo.AuthAccountVo;
import demo.cloud.api.auth.vo.TokenInfoVo;
import demo.cloud.common.core.feign.FeignInsideAuthConfig;
import demo.cloud.common.core.response.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "demo-auth",contextId ="account")
public interface AccountFeignClient {

    /**
     * 保存用户信息，生成token，返回前端
     * @param userInfoInTokenBO 账户信息 和社交账号信息
     * @return uid
     */
    @PostMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/storeTokenAndGetVo")
    Resp<TokenInfoVo> storeTokenAndGetVo(@RequestBody UserInfoInTokenBo userInfoInTokenBo);

    /**
     * 根据用户名和系统类型获取用户信息
     * @param username
     * @param sysType
     * @return
     */
    @PostMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/getByUsernameAndSysType")
    Resp<AuthAccountVo> getByUsernameAndSysType(@RequestParam("userName") String username, @RequestParam("sysType") SysTypeEnum sysType);


    /**
     * 保存统一账户
     * @param authAccountDTO 账户信息
     * @return Long uid
     */
    @PostMapping(value = FeignInsideAuthConfig.FEIGN_INSIDE_URL_PREFIX + "/insider/account")
    Resp<Long> save(@RequestBody AuthAccountDto authAccountDTO);

}
