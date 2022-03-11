package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 商品sku销售属性关联信息(SpuSkuAttrValue)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:52:20
 */
@SuppressWarnings("serial")
public class SpuSkuAttrValue extends Model<SpuSkuAttrValue> {
    //商品sku销售属性关联信息id
    private Object spuSkuAttrId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //SPU ID
    private Long spuId;
    //SKU ID
    private Long skuId;
    //销售属性ID
    private Integer attrId;
    //销售属性名称
    private String attrName;
    //销售属性值ID
    private Integer attrValueId;
    //销售属性值
    private String attrValueName;
    //状态 1:enable, 0:disable, -1:deleted
    private Integer status;


    public Object getSpuSkuAttrId() {
        return spuSkuAttrId;
    }

    public void setSpuSkuAttrId(Object spuSkuAttrId) {
        this.spuSkuAttrId = spuSkuAttrId;
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

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Integer getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Integer attrValueId) {
        this.attrValueId = attrValueId;
    }

    public String getAttrValueName() {
        return attrValueName;
    }

    public void setAttrValueName(String attrValueName) {
        this.attrValueName = attrValueName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}

