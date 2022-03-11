package demo.cloud.product.controller.admin;

import demo.api.product.vo.CategoryVO;
import demo.cloud.common.core.constant.Constant;
import demo.cloud.common.core.response.Resp;
import demo.cloud.product.dto.CategoryDto;
import demo.cloud.product.entity.Category;
import demo.cloud.product.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController("adminCategoryController")
@RequestMapping("/admin/category")
@Api(tags = "admin-分类信息")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    @ApiOperation(value = "保存分类信息", notes = "保存分类信息")
    public Resp<Void> save(@Valid @RequestBody CategoryDto categoryDto) {
        Assert.isTrue(categoryDto.getLevel() >= 2, "只能添加二级及以下目录");
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.save(category);
        //删除缓存
        //categoryService.removeCategoryCache(AuthUserContext.get().getTenantId(), category.getParentId());
        return Resp.succ();
    }


    @PostMapping("/platform_categories")
    @ApiOperation(value = "获取平台所有的分类信息", notes = "获取所有的分类列表信息")
    public Resp<List<CategoryVO>> platformCategories() {
        return Resp.succ(categoryService.list(Constant.PLATFORM_SHOP_ID));
    }

    @GetMapping("/shop_categories")
    @ApiOperation(value = "获取店铺所有的分类信息", notes = "获取店铺所有的分类信息")
    public Resp<List<CategoryVO>> shopCategories() {
        return Resp.succ(categoryService.list(AuthUserContext.get().getTenantId()));
    }
}
