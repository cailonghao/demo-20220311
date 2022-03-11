package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 库存信息(SkuStock)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:51:59
 */
@SuppressWarnings("serial")
public class SkuStock extends Model<SkuStock> {
    //库存id
    private Long stockId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //SKU ID
    private Long skuId;
    //实际库存
    private Object actualStock;
    //锁定库存
    private Object lockStock;
    //可售卖库存
    private Object stock;


    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
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

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Object getActualStock() {
        return actualStock;
    }

    public void setActualStock(Object actualStock) {
        this.actualStock = actualStock;
    }

    public Object getLockStock() {
        return lockStock;
    }

    public void setLockStock(Object lockStock) {
        this.lockStock = lockStock;
    }

    public Object getStock() {
        return stock;
    }

    public void setStock(Object stock) {
        this.stock = stock;
    }



}

