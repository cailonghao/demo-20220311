package demo.cloud.product.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 分类信息(Category)表实体类
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
@Data
public class Category extends Model<Category> {

    //分类id
    @TableId("category_id")
    private Long categoryId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //店铺id
    private Long shopId;
    //父ID
    private Long parentId;
    //分类名称
    private String name;
    //分类描述
    private String descp;
    //分类地址{parent_id}-{child_id},...
    private String path;
    //状态 1:enable, 0:disable, -1:deleted
    private Integer status;
    //分类图标
    private String icon;
    //分类的显示图片
    private String imgUrl;
    //分类层级 从0开始
    private Integer level;
    //排序
    private Integer seq;



}

