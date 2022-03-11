package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * spu信息(Spu)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:52:09
 */
@SuppressWarnings("serial")
@Data
public class Spu extends Model<Spu> {
    //spu id
    @TableId("spuId")
    private Long spuId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //品牌ID
    private Long brandId;
    //分类ID
    private Long categoryId;
    //店铺分类ID
    private Long shopCategoryId;
    //店铺id
    private Long shopId;
    //商品名称
    private String name;
    //卖点
    private String sellingPoint;
    //商品介绍主图
    private String mainImgUrl;
    //商品图片 多个图片逗号分隔
    private String imgUrls;
    //商品视频
    private String video;
    //售价，整数方式保存
    private Long priceFee;
    //市场价，整数方式保存
    private Long marketPriceFee;
    //状态 -1:删除, 0:下架, 1:上架
    private Integer status;
    //sku是否含有图片 0无 1有
    private Integer hasSkuImg;
    //序号
    private Integer seq;


}

