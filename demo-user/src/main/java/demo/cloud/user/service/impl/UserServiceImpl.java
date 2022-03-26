package demo.cloud.user.service.impl;

import demo.cloud.api.auth.constant.SysTypeEnum;
import demo.cloud.api.auth.dto.AuthAccountDto;
import demo.cloud.api.auth.feign.AccountFeignClient;
import demo.cloud.api.auth.vo.AuthAccountVo;
import demo.cloud.api.user.vo.UserApiVo;
import demo.cloud.common.cache.constant.UserCacheNames;
import demo.cloud.common.core.exception.DemoException;
import demo.cloud.common.core.response.Resp;
import demo.cloud.common.core.util.IpHelper;
import demo.cloud.user.dto.UserRegisterDto;
import demo.cloud.user.mapper.UserMapper;
import demo.cloud.user.model.User;
import demo.cloud.user.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    private AccountFeignClient accountFeignClient;


    @Override
    @Cacheable(cacheNames = UserCacheNames.USER_INFO, key = "#userId")
    public UserApiVo getByUserId(Long userId) {
        return userMapper.getByUserId(userId);
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public Long save(UserRegisterDto param) {
        this.checkRegisterInfo(param);
        AuthAccountDto authAccountDTO = new AuthAccountDto();
        authAccountDTO.setCreateIp(IpHelper.getIpAddr());
        authAccountDTO.setPassword(param.getPassword());
        authAccountDTO.setIsAdmin(0);
        authAccountDTO.setSysType(SysTypeEnum.ORDINARY.value());
        authAccountDTO.setUsername(param.getUserName());
        authAccountDTO.setStatus(1);
        Long userId = System.currentTimeMillis();
        authAccountDTO.setUserId(userId);
        // 保存统一账户信息
        Resp<Long> serverResponse = accountFeignClient.save(authAccountDTO);
        // 抛异常回滚
        if (!serverResponse.isSuccess()) {
            throw new DemoException(serverResponse.getMsg());
        }

        User user = new User();
        user.setUserId(userId);
        user.setPic(param.getImg());
        user.setNickName(param.getNickName());
        user.setStatus(1);
        // 这里保存之后才有用户id
        userMapper.save(user);

        return serverResponse.getData();
    }


    private void checkRegisterInfo(UserRegisterDto userRegisterDTO) {
        Resp<AuthAccountVo> responseEntity = accountFeignClient.getByUsernameAndSysType(userRegisterDTO.getUserName(), SysTypeEnum.ORDINARY);
        if (!responseEntity.isSuccess()) {
            throw new DemoException(responseEntity.getMsg());
        }
        if (Objects.nonNull(responseEntity.getData())) {
            throw new DemoException("用户名已存在");
        }
    }

}
