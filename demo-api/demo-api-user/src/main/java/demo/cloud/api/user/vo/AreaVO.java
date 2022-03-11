package demo.cloud.api.user.vo;

import demo.cloud.common.core.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
public class AreaVO extends BaseVO {

    @ApiModelProperty()
    private Long areaId;

    @ApiModelProperty("地址")
    private String areaName;

    @ApiModelProperty("上级地址")
    private Long parentId;

    @ApiModelProperty("等级（从1开始）")
    private Integer level;

    private Integer check;

    /**
     * 下级地址集合
     */
    private List<AreaVO> areas;

    /**
     * 下级地址的areaId
     */
    private List<Long> areaIds;
}
