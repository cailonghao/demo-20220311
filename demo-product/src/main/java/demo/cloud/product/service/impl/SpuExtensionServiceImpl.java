package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.SpuExtensionDao;
import demo.cloud.product.entity.SpuExtension;
import demo.cloud.product.service.SpuExtensionService;
import org.springframework.stereotype.Service;

/**
 * (SpuExtension)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:18
 */
@Service("spuExtensionService")
public class SpuExtensionServiceImpl extends ServiceImpl<SpuExtensionDao, SpuExtension> implements SpuExtensionService {

}

