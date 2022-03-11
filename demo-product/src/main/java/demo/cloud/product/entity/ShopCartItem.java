package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 购物车(ShopCartItem)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
@SuppressWarnings("serial")
public class ShopCartItem extends Model<ShopCartItem> {
    //主键
    private Long cartItemId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //店铺ID
    private Long shopId;
    //产品ID
    private Long spuId;
    //SkuID
    private Long skuId;
    //用户ID
    private Long userId;
    //购物车产品个数
    private Integer count;
    //售价，加入购物车时的商品价格
    private Long priceFee;
    //是否已勾选
    private Integer isChecked;


    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getPriceFee() {
        return priceFee;
    }

    public void setPriceFee(Long priceFee) {
        this.priceFee = priceFee;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }



}

