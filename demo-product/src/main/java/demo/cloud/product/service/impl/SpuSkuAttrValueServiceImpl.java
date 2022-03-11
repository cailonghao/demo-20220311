package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.SpuSkuAttrValueDao;
import demo.cloud.product.entity.SpuSkuAttrValue;
import demo.cloud.product.service.SpuSkuAttrValueService;
import org.springframework.stereotype.Service;

/**
 * 商品sku销售属性关联信息(SpuSkuAttrValue)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:22
 */
@Service("spuSkuAttrValueService")
public class SpuSkuAttrValueServiceImpl extends ServiceImpl<SpuSkuAttrValueDao, SpuSkuAttrValue> implements SpuSkuAttrValueService {

}

