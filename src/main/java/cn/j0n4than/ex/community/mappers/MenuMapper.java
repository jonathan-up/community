package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.entities.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    List<Menu> select(Menu condition);

    int deleteByIds(@Param("ids") List<Object> ids);

    int insertBatch(@Param("records") List<Menu> records);

    int updateOne(Menu record);

    Menu selectById(Object id);

    List<Menu> selectMenuForUser(Object id);
}
