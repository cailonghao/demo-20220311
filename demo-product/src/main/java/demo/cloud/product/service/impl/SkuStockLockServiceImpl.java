package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.SkuStockLockDao;
import demo.cloud.product.entity.SkuStockLock;
import demo.cloud.product.service.SkuStockLockService;
import org.springframework.stereotype.Service;

/**
 * 库存锁定信息(SkuStockLock)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:07
 */
@Service("skuStockLockService")
public class SkuStockLockServiceImpl extends ServiceImpl<SkuStockLockDao, SkuStockLock> implements SkuStockLockService {

}

