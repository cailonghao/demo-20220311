package demo.cloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import demo.cloud.product.controller.dto.SpuDto;
import demo.cloud.product.entity.Spu;

/**
 * spu信息(Spu)表服务接口
 *
 * @author makejava
 * @since 2022-03-03 16:52:09
 */
public interface SpuService extends IService<Spu> {

    void saveSpuDto(SpuDto spuDto);
}

