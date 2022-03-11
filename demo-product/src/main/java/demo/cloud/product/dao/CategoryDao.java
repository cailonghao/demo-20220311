package demo.cloud.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import demo.cloud.api.product.vo.CategoryVO;
import demo.cloud.product.entity.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 分类信息(Category)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
public interface CategoryDao extends BaseMapper<Category> {

    @Select("select c.category_id,c.shop_id,c.parent_id,c.name,c.descp,c.path,c.status,c.icon,c.img_url,c.level,c.seq where status= 1 and parent_id = #{platformShopId}")
    List<CategoryVO> selectCategoryByPid(long platformShopId);
}

