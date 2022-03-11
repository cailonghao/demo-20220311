package demo.cloud.product.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 商品规格属性关联信息(SpuAttrValue)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:52:11
 */
@SuppressWarnings("serial")
public class SpuAttrValue extends Model<SpuAttrValue> {
    //商品属性值关联信息id
    private Long spuAttrValueId;
    //商品id
    private Long spuId;
    //规格属性id
    private Long attrId;
    //规格属性名称
    private String attrName;
    //规格属性值id
    private Long attrValueId;
    //规格属性值名称
    private String attrValueName;
    //规格属性描述
    private String attrDesc;


    public Long getSpuAttrValueId() {
        return spuAttrValueId;
    }

    public void setSpuAttrValueId(Long spuAttrValueId) {
        this.spuAttrValueId = spuAttrValueId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Long getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public String getAttrValueName() {
        return attrValueName;
    }

    public void setAttrValueName(String attrValueName) {
        this.attrValueName = attrValueName;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }


}

