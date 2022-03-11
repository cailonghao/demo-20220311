package demo.cloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import demo.api.product.vo.CategoryVO;
import demo.cloud.product.entity.Category;

import java.util.List;

/**
 * 分类信息(Category)表服务接口
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
public interface CategoryService extends IService<Category> {

    List<CategoryVO> list(long platformShopId);
}

