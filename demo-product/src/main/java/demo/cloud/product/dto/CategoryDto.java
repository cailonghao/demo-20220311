package demo.cloud.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDto {

    @ApiModelProperty("分类id")
    private Long categoryId;

    @ApiModelProperty("店铺id")
    private Long shopId;

    @NotNull(message = "请选择上级分类")
    @ApiModelProperty("父ID")
    private Long parentId;

    @NotBlank(message = "分类名称不能为空")
    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类描述")
    private String descp;

    @ApiModelProperty("分类地址{parent_id}-{child_id},...")
    private String path;

    @NotNull(message = "状态不能为空")
    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Integer status;

    @ApiModelProperty("分类图标")
    private String icon;

    @ApiModelProperty("分类的显示图片")
    private String imgUrl;

    @ApiModelProperty("分类层级 从0开始")
    private Integer level;

    @ApiModelProperty("排序")
    private Integer seq;
}
