package demo.cloud.auth.mapper;

import demo.cloud.api.auth.vo.AuthAccountVo;
import demo.cloud.auth.model.AuthAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AuthAccountMapper {
    @Select("select uid, username auth_account where username = #{username} and sys_type = #{value} and status != 1")
    AuthAccountVo getByUsernameAndSysType(String username, Integer value);

    @Insert("insert into auth_account (`uid`,`username`,`password`,`create_ip`,`status`,`sys_type`,`user_id`,`tenant_id`,`is_admin`) values (#{authAccount.uid},#{authAccount.username},#{authAccount.password},#{authAccount.createIp},#{authAccount.status},#{authAccount.sysType},#{authAccount.userId},#{authAccount.tenantId},#{authAccount.isAdmin})")
    void save(AuthAccount data);
}
