package demo.cloud.user.controller.app;

import demo.cloud.api.user.vo.UserApiVo;
import demo.cloud.common.core.common.security.AuthUserContext;
import demo.cloud.common.core.response.Resp;
import demo.cloud.user.service.UserService;
import demo.cloud.user.vo.UserSimpleInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("appUserController")
@RequestMapping("/app/user")
@Api(tags = "app-用户信息")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/simple_info")
    @ApiOperation(value="用户头像昵称", notes="用户头像昵称")
    public Resp<UserSimpleInfoVO> getUserByAddrId(){
        Long userId = AuthUserContext.get().getUserId();
        UserApiVo userApiVO = userService.getByUserId(userId);
        UserSimpleInfoVO userSimpleInfoVO = new UserSimpleInfoVO();
        userSimpleInfoVO.setNickName(userApiVO.getNickName());
        userSimpleInfoVO.setPic(userApiVO.getPic());
        return Resp.succ(userSimpleInfoVO);
    }
}
