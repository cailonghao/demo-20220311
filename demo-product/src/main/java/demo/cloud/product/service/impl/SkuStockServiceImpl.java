package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.SkuStockDao;
import demo.cloud.product.entity.SkuStock;
import demo.cloud.product.service.SkuStockService;
import org.springframework.stereotype.Service;

/**
 * 库存信息(SkuStock)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:02
 */
@Service("skuStockService")
public class SkuStockServiceImpl extends ServiceImpl<SkuStockDao, SkuStock> implements SkuStockService {

}

