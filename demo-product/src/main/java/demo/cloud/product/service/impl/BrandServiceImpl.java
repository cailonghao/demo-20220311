package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.api.product.vo.BrandVO;
import demo.cloud.common.core.constant.StatusEnum;
import demo.cloud.product.service.CategoryBrandService;
import demo.cloud.product.dao.BrandDao;
import demo.cloud.product.entity.Brand;
import demo.cloud.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 品牌信息(Brand)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, Brand> implements BrandService {

    @Autowired
    private CategoryBrandService categoryBrandService;

    @Override
    public List<BrandVO> getBrandByCategoryId(Long categoryId) {
        return baseMapper.getBrandByCategoryId(categoryId);
    }

    @Override
    public void save(Brand brand, List<Long> categoryIds) {
        brand.setFirstLetter(brand.getFirstLetter().toUpperCase());
        brand.setStatus(StatusEnum.ENABLE.value());
        save(brand);
        categoryBrandService.saveByCategoryIds(brand.getBrandId(), categoryIds);
    }
}

