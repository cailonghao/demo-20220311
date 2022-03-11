package demo.cloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import demo.cloud.api.product.vo.BrandVO;
import demo.cloud.product.entity.Brand;

import java.util.List;

/**
 * 品牌信息(Brand)表服务接口
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
public interface BrandService extends IService<Brand> {

    List<BrandVO> getBrandByCategoryId(Long categoryId);

    void save(Brand brand, List<Long> categoryIds);
}

