package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * (SpuExtension)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:52:17
 */
@SuppressWarnings("serial")
public class SpuExtension extends Model<SpuExtension> {
    //商品扩展信息表id
    private Long spuExtendId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //商品id
    private Long spuId;
    //销量
    private Object saleNum;
    //实际库存
    private Object actualStock;
    //锁定库存
    private Object lockStock;
    //可售卖库存
    private Object stock;


    public Long getSpuExtendId() {
        return spuExtendId;
    }

    public void setSpuExtendId(Long spuExtendId) {
        this.spuExtendId = spuExtendId;
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

    public Object getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Object saleNum) {
        this.saleNum = saleNum;
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

