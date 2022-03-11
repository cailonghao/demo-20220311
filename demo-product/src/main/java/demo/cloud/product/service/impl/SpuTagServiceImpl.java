package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.SpuTagDao;
import demo.cloud.product.entity.SpuTag;
import demo.cloud.product.service.SpuTagService;
import org.springframework.stereotype.Service;

/**
 * 商品分组表(SpuTag)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:24
 */
@Service("spuTagService")
public class SpuTagServiceImpl extends ServiceImpl<SpuTagDao, SpuTag> implements SpuTagService {

}

