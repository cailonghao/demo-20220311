package demo.cloud.user.mapper;

import demo.cloud.api.user.vo.UserApiVo;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("")
    UserApiVo getByUserId(Long userId);
}
