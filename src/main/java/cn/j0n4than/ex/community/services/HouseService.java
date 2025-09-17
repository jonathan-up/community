package cn.j0n4than.ex.community.services;

import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.House;
import cn.j0n4than.ex.community.pojo.vo.HouseVo;

import java.util.List;

public interface HouseService {

    Page<HouseVo> findPage(HouseVo condition, int current, int size);

    int del(List<Object> ids);

    int insert(List<House> records);

    int update(House record);

    House findOne(Object id);
}
