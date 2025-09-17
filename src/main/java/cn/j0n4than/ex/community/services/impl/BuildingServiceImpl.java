package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.SqlSessionHolder;
import cn.j0n4than.ex.community.mappers.BuildingMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.Building;
import cn.j0n4than.ex.community.pojo.vo.BuildingVo;
import cn.j0n4than.ex.community.services.BuildingService;
import com.github.pagehelper.PageHelper;

import java.util.List;

public class BuildingServiceImpl implements BuildingService {

    @Override
    public Page<BuildingVo> findPage(BuildingVo condition, int current, int size) {

        BuildingMapper buildingMapper = SqlSessionHolder.value.get().getMapper(BuildingMapper.class);
        try (com.github.pagehelper.Page<BuildingVo> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> buildingMapper.select(condition))) {
            Page<BuildingVo> buildingVoPage = new Page<>(current, size);
            buildingVoPage.setTotal((int) pageInfo.getTotal());
            buildingVoPage.setRecords(pageInfo.getResult());

            return buildingVoPage;
        }
    }

    @Override
    public int del(List<Object> ids) {

        BuildingMapper buildingMapper = SqlSessionHolder.value.get().getMapper(BuildingMapper.class);
        return buildingMapper.deleteByIds(ids);
    }

    @Override
    public int insert(List<Building> records) {

        BuildingMapper buildingMapper = SqlSessionHolder.value.get().getMapper(BuildingMapper.class);
        return buildingMapper.insertBatch(records);
    }

    @Override
    public int update(Building building) {

        BuildingMapper buildingMapper = SqlSessionHolder.value.get().getMapper(BuildingMapper.class);
        return buildingMapper.updateOne(building);
    }

    @Override
    public Building findOne(Object id) {

        BuildingMapper buildingMapper = SqlSessionHolder.value.get().getMapper(BuildingMapper.class);
        return buildingMapper.selectById(id);
    }
}
