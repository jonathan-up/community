package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.entities.Role;
import cn.j0n4than.ex.community.pojo.entities.RoleMenu;
import cn.j0n4than.ex.community.pojo.entities.RoleUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> select(Role condition);

    List<Role> selectByUserId(Object id);

    int deleteByIds(@Param("ids") List<Object> ids);

    int insertBatch(@Param("records") List<Role> records);

    int updateOne(Role record);

    Role selectById(Object id);

    int switchStatus(Object id);

    int deleteRoleUserByUserId(Object id);

    int deleteRoleMenuByRoleId(Object id);
    int deleteRoleUserByRoleId(Object id);
    int deleteRoleResourceByRoleId(Object id);

    int insertRoleUser(@Param("records") List<RoleUser> records);

    int insertRoleMenu(@Param("records") List<RoleMenu> records);
}
