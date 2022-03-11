package demo.cloud.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import demo.cloud.api.product.vo.BrandVO;
import demo.cloud.product.entity.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 品牌信息(Brand)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
public interface BrandDao extends BaseMapper<Brand> {

    @Select("SELECT b.* FROM brand AS b JOIN category_brand AS cb ON b.brand_id = cb.brand_id AND cb.category_id = #{categoryId}")
    List<BrandVO> getBrandByCategoryId(Long categoryId);
}

