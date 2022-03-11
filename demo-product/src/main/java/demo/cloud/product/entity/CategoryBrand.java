package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 品牌分类关联信息(CategoryBrand)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
@SuppressWarnings("serial")
public class CategoryBrand extends Model<CategoryBrand> {

    private Long id;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //品牌id
    private Long brandId;
    //分类id
    private Long categoryId;


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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }



}

