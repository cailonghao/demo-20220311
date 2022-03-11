package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.CategoryBrandDao;
import demo.cloud.product.entity.CategoryBrand;
import demo.cloud.product.service.CategoryBrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 品牌分类关联信息(CategoryBrand)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
@Service("categoryBrandService")
public class CategoryBrandServiceImpl extends ServiceImpl<CategoryBrandDao, CategoryBrand> implements CategoryBrandService {

    @Override
    public void saveByCategoryIds(Long brandId, List<Long> categoryIds) {
        if (categoryIds == null) {
            return;
        }
        List<CategoryBrand> categoryBrandList = new ArrayList<>();
        categoryIds.forEach(categoryId -> {
            CategoryBrand categoryBrand = new CategoryBrand();
            categoryBrand.setBrandId(brandId);
            categoryBrand.setCategoryId(categoryId);
            categoryBrandList.add(categoryBrand);
        });
        saveBatch(categoryBrandList);
    }
}

