package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 商品分组标签关联信息(SpuTagReference)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:52:26
 */
@SuppressWarnings("serial")
public class SpuTagReference extends Model<SpuTagReference> {
    //分组引用id
    private Long referenceId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //店铺id
    private Long shopId;
    //标签id
    private Long tagId;
    //商品id
    private Long spuId;
    //状态(1:正常,-1:删除)
    private Integer status;
    //排序
    private Integer seq;


    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
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

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }


}

