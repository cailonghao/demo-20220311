package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.SpuTagReferenceDao;
import demo.cloud.product.entity.SpuTagReference;
import demo.cloud.product.service.SpuTagReferenceService;
import org.springframework.stereotype.Service;

/**
 * 商品分组标签关联信息(SpuTagReference)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:27
 */
@Service("spuTagReferenceService")
public class SpuTagReferenceServiceImpl extends ServiceImpl<SpuTagReferenceDao, SpuTagReference> implements SpuTagReferenceService {

}

