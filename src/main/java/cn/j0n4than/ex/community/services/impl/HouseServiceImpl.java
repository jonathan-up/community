package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.SqlSessionHolder;
import cn.j0n4than.ex.community.mappers.HouseMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.House;
import cn.j0n4than.ex.community.pojo.vo.HouseVo;
import cn.j0n4than.ex.community.services.HouseService;
import com.github.pagehelper.PageHelper;

import java.util.List;

public class HouseServiceImpl implements HouseService {

    @Override
    public Page<HouseVo> findPage(HouseVo condition, int current, int size) {

        HouseMapper mapper = SqlSessionHolder.value.get().getMapper(HouseMapper.class);
        try (com.github.pagehelper.Page<HouseVo> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> mapper.select(condition))) {
            Page<HouseVo> thePage = new Page<>(current, size);
            thePage.setTotal((int) pageInfo.getTotal());
            thePage.setRecords(pageInfo.getResult());

            return thePage;
        }
    }

    @Override
    public int del(List<Object> ids) {

        HouseMapper mapper = SqlSessionHolder.value.get().getMapper(HouseMapper.class);
        return mapper.deleteByIds(ids);
    }

    @Override
    public int insert(List<House> records) {

        HouseMapper mapper = SqlSessionHolder.value.get().getMapper(HouseMapper.class);
        return mapper.insertBatch(records);
    }

    @Override
    public int update(House record) {

        HouseMapper mapper = SqlSessionHolder.value.get().getMapper(HouseMapper.class);
        return mapper.updateOne(record);
    }

    @Override
    public House findOne(Object id) {

        HouseMapper mapper = SqlSessionHolder.value.get().getMapper(HouseMapper.class);
        return mapper.selectById(id);
    }
}
