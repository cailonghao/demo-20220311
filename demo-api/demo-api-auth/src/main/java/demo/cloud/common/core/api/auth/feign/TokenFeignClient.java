package demo.cloud.common.core.api.auth.feign;


import demo.cloud.common.core.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.common.core.api.auth.vo.TokenInfoVO;
import demo.cloud.common.core.constant.Auth;
import demo.cloud.common.core.feign.FeignInsideAuthConfig;
import demo.cloud.common.core.response.Resp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mall4cloud-auth", contextId = "token")
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
