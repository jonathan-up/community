package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.vo.BuildingVo;

import java.util.List;

public interface BuildingMapper {
    List<BuildingVo> selectByName(String name);
}
