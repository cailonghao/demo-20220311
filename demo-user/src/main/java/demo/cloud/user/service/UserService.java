package demo.cloud.user.service;

import demo.cloud.api.user.vo.UserApiVo;
import demo.cloud.user.dto.UserRegisterDto;

public interface UserService {
    UserApiVo getByUserId(Long userId);

    Long save(UserRegisterDto param);
}
