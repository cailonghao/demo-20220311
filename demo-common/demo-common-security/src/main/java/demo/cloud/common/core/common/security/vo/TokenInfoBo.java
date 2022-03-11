package demo.cloud.common.core.common.security.vo;

import demo.cloud.common.core.api.auth.bo.UserInfoInTokenBo;
import lombok.Data;

@Data
public class TokenInfoBo {

    /**
     * 保存在token信息里面的用户信息
     */
    private UserInfoInTokenBo userInfoInToken;

    private String accessToken;

    private String refreshToken;

    /**
     * 在多少秒后过期
     */
    private Integer expiresIn;
}
