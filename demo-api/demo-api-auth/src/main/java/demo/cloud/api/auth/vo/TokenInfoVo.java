package demo.cloud.api.auth.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TokenInfoVo {

    @ApiModelProperty("accessToken")
    private String accessToken;

    @ApiModelProperty("refreshToken")
    private String refreshToken;

    @ApiModelProperty("在多少秒后过期")
    private Integer expiresIn;
}
