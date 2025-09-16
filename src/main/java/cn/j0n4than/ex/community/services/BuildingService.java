package cn.j0n4than.ex.community.services;

import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.vo.BuildingVo;

import java.util.List;

public interface BuildingService {

    Page<BuildingVo> findPage(String name, int current, int size);
    int del(List<Object> ids);
}
