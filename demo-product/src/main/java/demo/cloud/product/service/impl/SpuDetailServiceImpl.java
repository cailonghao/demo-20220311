package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.SpuDetailDao;
import demo.cloud.product.entity.SpuDetail;
import demo.cloud.product.service.SpuDetailService;
import org.springframework.stereotype.Service;

/**
 * 商品详情信息(SpuDetail)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:15
 */
@Service("spuDetailService")
public class SpuDetailServiceImpl extends ServiceImpl<SpuDetailDao, SpuDetail> implements SpuDetailService {

}

