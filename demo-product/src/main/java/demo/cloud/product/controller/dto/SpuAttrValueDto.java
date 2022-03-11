package demo.cloud.product.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SpuAttrValueDto {

    @ApiModelProperty("商品属性值关联信息id")
    private Long spuAttrValueId;

    @ApiModelProperty("商品id")
    private Long spuId;

    @ApiModelProperty("规格属性id")
    private Long attrId;

    @ApiModelProperty("规格属性名称")
    private String attrName;

    @ApiModelProperty("规格属性值id")
    private Long attrValueId;

    @ApiModelProperty("规格属性值名称")
    private String attrValueName;
}
