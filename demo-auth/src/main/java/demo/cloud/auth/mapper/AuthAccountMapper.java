package demo.cloud.auth.mapper;

import demo.cloud.api.auth.vo.AuthAccountVo;
import org.apache.ibatis.annotations.Select;

public interface AuthAccountMapper {
    @Select("select uid, username auth_account where username = #{username} and sys_type = #{value} and status != 1")
    AuthAccountVo getByUsernameAndSysType(String username, Integer value);
}
