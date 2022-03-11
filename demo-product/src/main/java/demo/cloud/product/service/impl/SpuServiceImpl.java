package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.cloud.product.controller.dto.SpuDto;
import demo.cloud.product.entity.SpuAttrValue;
import demo.cloud.common.core.product.service.*;
import demo.cloud.common.core.constant.StatusEnum;
import demo.cloud.product.dao.SpuDao;
import demo.cloud.product.entity.Spu;
import demo.cloud.product.entity.SpuDetail;
import demo.cloud.product.entity.SpuExtension;
import demo.cloud.product.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * spu信息(Spu)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:52:10
 */
@Service("spuService")
public class SpuServiceImpl extends ServiceImpl<SpuDao, Spu> implements SpuService {


    @Autowired
    private SpuAttrValueService spuAttrValueService;
    @Autowired
    private SpuDetailService spuDetailService;
    @Autowired
    private SpuExtensionService spuExtensionService;
    @Autowired
    private SkuService skuService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSpuDto(SpuDto spuDto) {
        ObjectMapper mapper = new ObjectMapper();
        Spu spu = mapper.convertValue(spuDto, Spu.class);
        spu.setShopId(0L);
        spu.setStatus(StatusEnum.ENABLE.value());
        //保存商品信息
        save(spu);
        //保存商品的其他信息
        List<SpuAttrValue> spuAttrValues = mapper.convertValue(spuDto.getSpuAttrValues(), new TypeReference<List<SpuAttrValue>>() {
        });
        for (SpuAttrValue spuAttrValue : spuAttrValues) {
            if (Objects.isNull(spuAttrValue.getAttrValueId())) {
                spuAttrValue.setAttrValueId(0L);
            }
        }
        spuAttrValueService.saveBatch(spu.getSpuId(), spuAttrValues);
        SpuDetail spuDetail = new SpuDetail();
        spuDetail.setSpuId(spu.getSpuId());
        spuDetail.setDetail(spuDto.getDetail());
        spuDetailService.save(spuDetail);

        SpuExtension spuExtension = new SpuExtension();
        spuExtension.setSpuId(spu.getSpuId());
        spuExtension.setActualStock(spuDto.getTotalStock());
        spuExtension.setStock(spuDto.getTotalStock());
        spuExtensionService.save(spuExtension);

        // 3.保存sku信息
        skuService.save(spu.getSpuId(), spuDto.getSkuList());
    }
}

