package demo.cloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import demo.cloud.product.controller.dto.SkuDto;
import demo.cloud.product.entity.Sku;

import java.util.List;

/**
 * sku信息(Sku)表服务接口
 *
 * @author makejava
 * @since 2022-03-03 16:36:30
 */
public interface SkuService extends IService<Sku> {

    void save(Long spuId, List<SkuDto> skuList);
}

