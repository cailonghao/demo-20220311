package demo.cloud.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserSimpleInfoVO {

    @ApiModelProperty(value = "用户昵称",required=true)
    private String nickName;

    @ApiModelProperty(value = "用户头像",required=true)
    private String pic;
}
