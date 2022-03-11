package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.cloud.product.dao.ShopCartItemDao;
import demo.cloud.product.entity.ShopCartItem;
import demo.cloud.product.service.ShopCartItemService;
import org.springframework.stereotype.Service;

/**
 * 购物车(ShopCartItem)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:36:30
 */
@Service("shopCartItemService")
public class ShopCartItemServiceImpl extends ServiceImpl<ShopCartItemDao, ShopCartItem> implements ShopCartItemService {

}

