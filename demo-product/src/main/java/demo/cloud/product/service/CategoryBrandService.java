package demo.cloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import demo.cloud.product.entity.CategoryBrand;

import java.util.List;

/**
 * 品牌分类关联信息(CategoryBrand)表服务接口
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
public interface CategoryBrandService extends IService<CategoryBrand> {

    void saveByCategoryIds(Long brandId, List<Long> categoryIds);
}

