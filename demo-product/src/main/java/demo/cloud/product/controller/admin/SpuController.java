package demo.cloud.product.controller.admin;

import demo.cloud.product.controller.dto.SpuDto;
import demo.cloud.common.core.response.Resp;
import demo.cloud.product.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/spu")
@Api(tags = "admin-spu")
public class SpuController {


    @Autowired
    SpuService spuService;


    @PostMapping
    @ApiOperation(value = "",notes = "")
    public Resp<Void> save(@Valid @RequestBody SpuDto spuDto){
        spuService.saveSpuDto(spuDto);
        return Resp.succ();
    }
}
