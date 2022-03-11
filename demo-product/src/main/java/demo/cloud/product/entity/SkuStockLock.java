package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 库存锁定信息(SkuStockLock)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:52:05
 */
@SuppressWarnings("serial")
public class SkuStockLock extends Model<SkuStockLock> {
    //id
    private Long id;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //商品id
    private Long spuId;
    //sku id
    private Long skuId;
    //订单id
    private Long orderId;
    //状态-1已解锁 0待确定 1已锁定
    private Integer status;
    //锁定库存数量
    private Integer count;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }



}

