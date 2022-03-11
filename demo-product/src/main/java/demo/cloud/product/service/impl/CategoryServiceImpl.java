package demo.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import demo.api.product.vo.CategoryVO;
import demo.cloud.product.dao.CategoryDao;
import demo.cloud.product.entity.Category;
import demo.cloud.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类信息(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-03-03 16:36:29
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {

    @Override
    public List<CategoryVO> list(long platformShopId) {
        return baseMapper.selectCategoryByPid(platformShopId);
    }
}

