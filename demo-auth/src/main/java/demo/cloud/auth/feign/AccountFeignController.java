package demo.cloud.auth.feign;

import demo.cloud.api.auth.constant.SysTypeEnum;
import demo.cloud.api.auth.dto.AuthAccountDto;
import demo.cloud.api.auth.vo.AuthAccountVo;
import demo.cloud.auth.manager.TokenStore;
import demo.cloud.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.api.auth.feign.AccountFeignClient;
import demo.cloud.api.auth.vo.TokenInfoVo;
import demo.cloud.auth.mapper.AuthAccountMapper;
import demo.cloud.auth.model.AuthAccount;
import demo.cloud.common.core.response.Resp;
import demo.cloud.common.core.util.PrincipalUtil;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AccountFeignController implements AccountFeignClient {

    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private AuthAccountMapper authAccountMapper;

    @Override
    public Resp<TokenInfoVo> storeTokenAndGetVo(UserInfoInTokenBo userInfoInTokenBo) {
        return Resp.succ(tokenStore.storeAndGetVo(userInfoInTokenBo));
    }

    @Override
    public Resp<AuthAccountVo> getByUsernameAndSysType(String username, SysTypeEnum sysType) {
        return Resp.succ(authAccountMapper.getByUsernameAndSysType(username, sysType.value()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Resp<Long> save(AuthAccountDto authAccountDTO) {
        Long userId = System.currentTimeMillis();
//        Resp<AuthAccount> verify = verify(authAccountDTO);
//        if (!verify.isSuccess()) {
//            return verify;
//        }
//        AuthAccount data = verify.getData();
        AuthAccount data =new AuthAccount();
        BeanUtils.copyProperties(authAccountDTO,data);
        data.setUid(userId);
        authAccountMapper.save(data);
        return Resp.succ(data.getUid());
    }

//    private Resp<AuthAccount> verify(AuthAccountDto authAccountDTO) {
//
//        // 用户名
//        if (!PrincipalUtil.isUserName(authAccountDTO.getUsername())) {
//            return Resp.showFailMsg("用户名格式不正确");
//        }
//        AuthAccountInVerifyBO userNameBo = authAccountMapper.getAuthAccountInVerifyByInputUserName(InputUserNameEnum.USERNAME.value(), authAccountDTO.getUsername(), authAccountDTO.getSysType());
//        if (userNameBo != null && !Objects.equals(userNameBo.getUserId(), authAccountDTO.getUserId())) {
//            return Resp.showFailMsg("用户名已存在，请更换用户名再次尝试");
//        }
//
//        AuthAccount authAccount = mapperFacade.map(authAccountDTO, AuthAccount.class);
//
//        if (StringUtils.isNotBlank(authAccount.getPassword())) {
//            authAccount.setPassword(passwordEncoder.encode(authAccount.getPassword()));
//        }
//
//        return ServerResponseEntity.success(authAccount);
//    }

}
