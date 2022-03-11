package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 品牌信息(Brand)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
@SuppressWarnings("serial")
public class Brand extends Model<Brand> {
    //brand_id
    @TableId("brand_id")
    private Long brandId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //品牌名称
    private String name;
    //品牌描述
    private String desc;
    //品牌logo图片
    private String imgUrl;
    //检索首字母
    private String firstLetter;
    //排序
    private Integer seq;
    //状态 1:enable, 0:disable, -1:deleted
    private Integer status;


    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



}

