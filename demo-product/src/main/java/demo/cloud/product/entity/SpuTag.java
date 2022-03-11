package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 商品分组表(SpuTag)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:52:23
 */
@SuppressWarnings("serial")
public class SpuTag extends Model<SpuTag> {
    //分组标签id
    private Long id;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //分组标题
    private String title;
    //店铺Id
    private Long shopId;
    //状态(1为正常,-1为删除)
    private Integer status;
    //默认类型(0:商家自定义,1:系统默认)
    private Integer isDefault;
    //商品数量
    private Long prodCount;
    //列表样式(0:一列一个,1:一列两个,2:一列三个)
    private Integer style;
    //排序
    private Integer seq;
    //删除时间
    private Date deleteTime;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Long getProdCount() {
        return prodCount;
    }

    public void setProdCount(Long prodCount) {
        this.prodCount = prodCount;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }


}

