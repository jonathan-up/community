package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int insertBatch(@Param("records") List<User> records);

    User selectByUsername(String username);

    List<User> select(User condition);

    int deleteByIds(@Param("ids") List<Object> ids);

    int updateOne(User record);

    int switchStatus(Object id);
}
