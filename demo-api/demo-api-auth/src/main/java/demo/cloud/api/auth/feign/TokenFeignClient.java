package demo.cloud.api.auth.feign;


import demo.cloud.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.common.core.constant.Auth;
import demo.cloud.common.core.response.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "demo-auth", contextId = "token")
public interface TokenFeignClient {

    /**
     * 校验token并返回token保存的用户信息
     *
     * @param accessToken accessToken
     * @return token保存的用户信息
     */
    @GetMapping(value = Auth.CHECK_TOKEN_URI)
    Resp<UserInfoInTokenBo> checkToken(@RequestParam("accessToken") String accessToken);


}
