package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.entities.Village;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VillageMapper {
    List<Village> selectByName(String name);
    Village selectById(Long id);

    int deleteByIds(@Param("ids") List<Object> ids);

    int insertBatch(@Param("records") List<Village> records);
}
