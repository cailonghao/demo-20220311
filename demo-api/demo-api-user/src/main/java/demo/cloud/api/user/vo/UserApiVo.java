package demo.cloud.api.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import demo.cloud.common.core.seriable.ImgJsonSerializer;
import demo.cloud.common.core.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserApiVo extends BaseVO {


    @ApiModelProperty("ID")
    private Long userId;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("头像图片路径")
    @JsonSerialize(using = ImgJsonSerializer.class)
    private String pic;

    @ApiModelProperty("状态 1 正常 0 无效")
    private Integer status;

    @ApiModelProperty("是否创建过店铺")

    /**
     * openId list
     */
    private List<String> bizUserIdList;
}
