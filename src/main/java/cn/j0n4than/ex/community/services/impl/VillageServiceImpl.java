package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.SqlSessionHolder;
import cn.j0n4than.ex.community.mappers.VillageMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.Village;
import cn.j0n4than.ex.community.services.VillageService;
import com.github.pagehelper.PageHelper;

import java.util.List;

public class VillageServiceImpl implements VillageService {
    @Override
    public Page<Village> findPage(String name, int current, int size) {

        VillageMapper mapper = SqlSessionHolder.value.get().getMapper(VillageMapper.class);
        try (com.github.pagehelper.Page<Village> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> mapper.selectByName(name))) {
            Page<Village> villagePage = new Page<>(current, size);
            villagePage.setTotal((int) pageInfo.getTotal());
            villagePage.setRecords(pageInfo.getResult());

            return villagePage;
        }
    }

    @Override
    public Village findOne(long id) {

        VillageMapper mapper = SqlSessionHolder.value.get().getMapper(VillageMapper.class);
        return mapper.selectById(id);
    }

    @Override
    public int del(List<Object> ids) {

        VillageMapper mapper = SqlSessionHolder.value.get().getMapper(VillageMapper.class);
        return mapper.deleteByIds(ids);
    }

    @Override
    public int insert(List<Village> records) {

        VillageMapper mapper = SqlSessionHolder.value.get().getMapper(VillageMapper.class);
        return mapper.insertBatch(records);
    }

    @Override
    public int update(Village village) {

        VillageMapper mapper = SqlSessionHolder.value.get().getMapper(VillageMapper.class);
        return mapper.updateOne(village);
    }
}
