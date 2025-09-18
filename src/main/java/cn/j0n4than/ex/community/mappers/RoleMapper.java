package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.entities.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> select(Role condition);

    int deleteByIds(@Param("ids") List<Object> ids);

    int insertBatch(@Param("records") List<Role> records);

    int updateOne(Role record);

    Role selectById(Object id);

    int switchStatus(Object id);
}
