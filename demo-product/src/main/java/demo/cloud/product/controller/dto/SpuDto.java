package demo.cloud.product.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SpuDto {

    @ApiModelProperty("spuId")
    private Long spuId;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @NotNull(message = "分类不能为空")
    @ApiModelProperty("分类ID")
    private Long categoryId;

    @NotNull(message = "店铺分类不能为空")
    @ApiModelProperty("店铺分类ID")
    private Long shopCategoryId;

    @NotNull(message = "商品名称不能为空")
    @ApiModelProperty("spu名称")
    private String name;

    @ApiModelProperty("卖点")
    private String sellingPoint;

    @NotNull(message = "商品轮播图不能为空")
    @ApiModelProperty("商品介绍主图 多个图片逗号分隔")
    private String imgUrls;

    @NotNull(message = "商品主图不能为空")
    @ApiModelProperty("商品主图")
    private String mainImgUrl;

    @ApiModelProperty("市场价")
    private Long marketPriceFee;

    @NotNull(message = "售价不能为空")
    @ApiModelProperty("售价")
    private Long priceFee;

    @ApiModelProperty("状态 1:enable, 0:disable, -1:deleted")
    private Integer status;

    @ApiModelProperty("商品属性值列表")
    private List<SpuAttrValueDto> spuAttrValues;

    @NotEmpty(message = "sku信息不能为空")
    @ApiModelProperty("商品规格列表")
    private List<SkuDto> skuList;

    @ApiModelProperty("商品详情")
    private String detail;

    @NotNull(message = "总库存不能为空")
    @ApiModelProperty("总库存")
    private Integer totalStock;

    @ApiModelProperty("更新时，变化的库存")
    private Integer changeStock;

    @ApiModelProperty("商品视频")
    private String video;

    @ApiModelProperty("sku是否含有图片 0无 1有")
    private Integer hasSkuImg;

    @ApiModelProperty("分组id")
    private Long tagId;

    @ApiModelProperty("序号")
    private Integer seq;

    @ApiModelProperty("spuId列表(商品上下架：批量操作时，用此参数)(批量处理参数)")
    private List<Long> spuIds;

    @ApiModelProperty("店铺id")
    private Long shopId;
}
