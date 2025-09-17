package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.entities.House;
import cn.j0n4than.ex.community.pojo.vo.HouseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    List<HouseVo> select(HouseVo condition);

    int deleteByIds(@Param("ids") List<Object> ids);

    int insertBatch(@Param("records") List<House> records);

    int updateOne(House record);

    HouseVo selectById(Object id);
}
