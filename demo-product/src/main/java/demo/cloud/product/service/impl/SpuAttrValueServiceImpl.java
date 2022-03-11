package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.SpuAttrValueDao;
import demo.cloud.product.entity.SpuAttrValue;
import demo.cloud.product.service.SpuAttrValueService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品规格属性关联信息(SpuAttrValue)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:12
 */
@Service("spuAttrValueService")
public class SpuAttrValueServiceImpl extends ServiceImpl<SpuAttrValueDao, SpuAttrValue> implements SpuAttrValueService {



    @Override
    public void saveBatch(Long spuId, List<SpuAttrValue> spuAttrValues) {
        if (spuAttrValues.isEmpty()) {
            return;
        }
        for (SpuAttrValue spuAttrValue : spuAttrValues) {
            spuAttrValue.setSpuId(spuId);
        }
        saveBatch(spuAttrValues);
    }
}

