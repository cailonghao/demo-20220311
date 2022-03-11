package demo.cloud.product.controller.admin;


import demo.cloud.api.product.vo.BrandVO;
import demo.cloud.common.core.response.Resp;
import demo.cloud.product.service.BrandService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌信息(Brand)表控制层
 *
 * @author makejava
 * @since 2022-03-03 16:36:28
 */
@RestController("brandBrandController")
@RequestMapping("/admin/brand")
public class BrandController {
    /**
     * 服务对象
     */
    @Resource
    private BrandService brandService;


    @PostMapping("/get_brand_by_category_id")
    @ApiImplicitParam(name = "categoryId",value = "分类id")
    @ApiOperation(value = "根据分类，获取品牌列表", notes = "根据分类，获取品牌列表")
    public Resp<List<BrandVO>> getBrandByCategoryId(@RequestParam Long categoryId) {
        return Resp.succ(brandService.getBrandByCategoryId(categoryId));
    }
}

