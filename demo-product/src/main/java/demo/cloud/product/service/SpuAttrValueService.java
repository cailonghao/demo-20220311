package demo.cloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import demo.cloud.product.entity.SpuAttrValue;

import java.util.List;

/**
 * 商品规格属性关联信息(SpuAttrValue)表服务接口
 *
 * @author makejava
 * @since 2022-03-03 16:52:11
 */
public interface SpuAttrValueService extends IService<SpuAttrValue> {

    void saveBatch(Long spuId, List<SpuAttrValue> spuAttrValues);
}

