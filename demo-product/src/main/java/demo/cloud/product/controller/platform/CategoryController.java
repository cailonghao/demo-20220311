package demo.cloud.product.controller.platform;

import demo.cloud.common.core.response.Resp;
import demo.cloud.product.constant.CategoryLevel;
import demo.cloud.product.dto.CategoryDto;
import demo.cloud.product.entity.Category;
import demo.cloud.product.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;


@RestController("platformCategoryController")
@RequestMapping("/platform/category")
@Api(tags = "platform-分类信息")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/save")
    @ApiOperation(value = "保存分类信息", notes = "保存分类信息")
    public Resp<Void> save(@Valid @RequestBody CategoryDto categoryDto) {
        Assert.isTrue(!Objects.equals(categoryDto.getLevel(), CategoryLevel.First.value()), "只能添加一级目录");
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.save(category);
        //删除缓存
        //categoryService.removeCategoryCache(AuthUserContext.get().getTenantId(), category.getParentId());
        return Resp.succ();
    }
}
