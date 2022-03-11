package demo.cloud.auth.feign;

import demo.cloud.common.core.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.common.core.api.auth.feign.AccountFeignClient;
import demo.cloud.common.core.api.auth.vo.TokenInfoVO;
import demo.cloud.common.core.response.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountFeignController implements AccountFeignClient {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public Resp<TokenInfoVO> storeTokenAndGetVo(UserInfoInTokenBo userInfoInTokenBo) {
        return Resp.succ(tokenStore.storeAndGetVo(userInfoInTokenBO));
    }
}
