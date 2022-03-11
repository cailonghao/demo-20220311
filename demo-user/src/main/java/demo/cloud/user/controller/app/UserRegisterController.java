package demo.cloud.user.controller.app;

import demo.cloud.common.core.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.common.core.api.auth.constant.SysTypeEnum;
import demo.cloud.common.core.api.auth.feign.AccountFeignClient;
import demo.cloud.common.core.api.auth.vo.TokenInfoVO;
import demo.cloud.common.core.response.Resp;
import demo.cloud.user.dto.UserRegisterDto;
import demo.cloud.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/app/user/register")
@Api(tags="app-用户注册接口")
public class UserRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @ApiOperation(value="注册")
    @PostMapping("/register")
    public Resp<TokenInfoVO> register(@Valid @RequestBody UserRegisterDto param) {

        if (StringUtils.isBlank(param.getNickName())) {
            param.setNickName(param.getUserName());
        }
        // 1. 保存账户信息
        Long uid = userService.save(param);
        // 2. 登录
        UserInfoInTokenBo userInfoInTokenBO = new UserInfoInTokenBo();
        userInfoInTokenBO.setUid(uid);
        userInfoInTokenBO.setUserId(param.getUserId());
        userInfoInTokenBO.setSysType(SysTypeEnum.ORDINARY.value());
        userInfoInTokenBO.setIsAdmin(0);
        return accountFeignClient.storeTokenAndGetVo(userInfoInTokenBO);
    }


}
