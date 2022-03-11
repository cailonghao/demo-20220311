package demo.cloud.user.mapper;

import demo.cloud.api.user.vo.UserApiVo;
import demo.cloud.user.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    UserApiVo getByUserId(Long userId);

    @Insert(" insert into user (`user_id`,`nick_name`,`pic`,`status`)values (#{user.userId},#{user.nickName},#{user.pic},#{user.status});")
    void save(User user);
}
