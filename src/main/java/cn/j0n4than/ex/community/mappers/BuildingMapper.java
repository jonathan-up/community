package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.vo.BuildingVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingMapper {
    List<BuildingVo> selectByName(String name);

    int deleteByIds(@Param("ids") List<Object> ids);
}
