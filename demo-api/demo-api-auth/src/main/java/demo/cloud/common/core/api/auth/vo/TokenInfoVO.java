package demo.cloud.common.core.api.auth.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TokenInfoVO {

    @ApiModelProperty("accessToken")
    private String accessToken;

    @ApiModelProperty("refreshToken")
    private String refreshToken;

    @ApiModelProperty("在多少秒后过期")
    private Integer expiresIn;
}
