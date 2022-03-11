package demo.cloud.product.controller.dto;

import io.swagger.annotations.ApiModelProperty;

public class SpuSkuAttrValueDto {

    @ApiModelProperty("商品sku销售属性关联信息id")
    private Integer spuSkuAttrId;

    @ApiModelProperty("SPU ID")
    private Long spuId;

    @ApiModelProperty("SKU ID")
    private Long skuId;

    @ApiModelProperty("销售属性ID")
    private Long attrId;

    @ApiModelProperty("销售属性名称")
    private String attrName;

    @ApiModelProperty("销售属性值ID")
    private Long attrValueId;

    @ApiModelProperty("销售属性值")
    private String attrValueName;

    @ApiModelProperty("状态 1:enable, 0:disable")
    private Integer status;

}
