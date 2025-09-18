package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.SqlSessionHolder;
import cn.j0n4than.ex.community.mappers.RoleMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.Role;
import cn.j0n4than.ex.community.services.RoleService;
import com.github.pagehelper.PageHelper;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Override
    public Page<Role> findPage(Role condition, int current, int size) {

        RoleMapper mapper = SqlSessionHolder.value.get().getMapper(RoleMapper.class);
        try (com.github.pagehelper.Page<Role> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> mapper.select(condition))) {
            Page<Role> thePage = new Page<>(current, size);
            thePage.setTotal((int) pageInfo.getTotal());
            thePage.setRecords(pageInfo.getResult());

            return thePage;
        }
    }

    @Override
    public int del(List<Object> ids) {

        RoleMapper mapper = SqlSessionHolder.value.get().getMapper(RoleMapper.class);
        return mapper.deleteByIds(ids);
    }

    @Override
    public int insert(List<Role> records) {

        RoleMapper mapper = SqlSessionHolder.value.get().getMapper(RoleMapper.class);
        return mapper.insertBatch(records);
    }

    @Override
    public int update(Role record) {

        RoleMapper mapper = SqlSessionHolder.value.get().getMapper(RoleMapper.class);
        return mapper.updateOne(record);
    }

    @Override
    public Role findOne(Object id) {

        RoleMapper mapper = SqlSessionHolder.value.get().getMapper(RoleMapper.class);
        return mapper.selectById(id);
    }

    @Override
    public int switchStatus(Object id) {
        RoleMapper mapper = SqlSessionHolder.value.get().getMapper(RoleMapper.class);
        return mapper.switchStatus(id);
    }
}
