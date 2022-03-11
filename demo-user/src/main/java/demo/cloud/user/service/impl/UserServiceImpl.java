package demo.cloud.user.service.impl;

import demo.cloud.api.user.vo.UserApiVo;
import demo.cloud.common.cache.constant.UserCacheNames;
import demo.cloud.user.mapper.UserMapper;
import demo.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Cacheable(cacheNames = UserCacheNames.USER_INFO, key = "#userId")
    public UserApiVo getByUserId(Long userId) {
        return userMapper.getByUserId(userId);
    }
}
