package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.cloud.product.controller.dto.SkuDto;
import demo.cloud.product.entity.SkuStock;
import demo.cloud.product.entity.SpuSkuAttrValue;
import demo.cloud.product.service.SkuStockService;
import demo.cloud.product.service.SpuSkuAttrValueService;
import demo.cloud.common.core.constant.StatusEnum;
import demo.cloud.product.dao.SkuDao;
import demo.cloud.product.entity.Sku;
import demo.cloud.product.service.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * sku信息(Sku)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:36:30
 */
@Service("skuService")
public class SkuServiceImpl extends ServiceImpl<SkuDao, Sku> implements SkuService {


    @Autowired
    private SkuStockService skuStockService;
    @Autowired
    private SpuSkuAttrValueService spuSkuAttrValueService;


    @Override
    public void save(Long spuId, List<SkuDto> skuList) {
        skuList.forEach(sku -> {
            sku.setSpuId(spuId);
            sku.setStatus(StatusEnum.ENABLE.value());
        });
        // 处理数据，保存库存、属性
        //skuMapper.saveBatch(skuList);
        List<Sku> skus = new ArrayList<>();
        BeanUtils.copyProperties(skuList, skus);
        saveBatch(skus);
        List<SkuStock> skuStocks = new ArrayList<>();
        List<SpuSkuAttrValue> spuSkuAttrValues = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (SkuDto skuDTO : skuList) {
            SkuStock skuStock = new SkuStock();
            skuStock.setSkuId(skuDTO.getSkuId());
            skuStock.setStock(skuDTO.getStock());
            skuStock.setActualStock(skuDTO.getStock());
            skuStock.setLockStock(0);
            skuStocks.add(skuStock);
            List<SpuSkuAttrValue> spuSkuAttrValueList = mapper.convertValue(skuDTO.getSpuSkuAttrValues(), new TypeReference<List<SpuSkuAttrValue>>() {
            });
            for (SpuSkuAttrValue spuSkuAttrValue : spuSkuAttrValueList) {
                spuSkuAttrValue.setSpuId(spuId);
                spuSkuAttrValue.setSkuId(skuDTO.getSkuId());
                spuSkuAttrValue.setStatus(StatusEnum.ENABLE.value());
                spuSkuAttrValues.add(spuSkuAttrValue);
            }
        }
        skuStockService.saveBatch(skuStocks);
        spuSkuAttrValueService.saveBatch(spuSkuAttrValues);
    }
}

