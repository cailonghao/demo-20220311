package demo.cloud.user.controller.app;

import demo.cloud.user.service.AreaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("appAreaController")
@RequestMapping("/app/area")
@Api(tags = "app-地区信息")
public class AreaController {

    @Autowired
    private AreaService areaService;

}
