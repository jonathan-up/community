package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.SqlSessionHolder;
import cn.j0n4than.ex.community.mappers.MenuMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.Menu;
import cn.j0n4than.ex.community.services.MenuService;
import com.github.pagehelper.PageHelper;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    @Override
    public List<Menu> findAll() {

        MenuMapper mapper = SqlSessionHolder.value.get().getMapper(MenuMapper.class);
        return mapper.selectAll();
    }

    @Override
    public int del(List<Object> ids) {

        MenuMapper mapper = SqlSessionHolder.value.get().getMapper(MenuMapper.class);
        return mapper.deleteByIds(ids);
    }

    @Override
    public int insert(List<Menu> records) {

        MenuMapper mapper = SqlSessionHolder.value.get().getMapper(MenuMapper.class);
        return mapper.insertBatch(records);
    }

    @Override
    public int update(Menu record) {

        MenuMapper mapper = SqlSessionHolder.value.get().getMapper(MenuMapper.class);
        return mapper.updateOne(record);
    }

    @Override
    public Menu findOne(Object id) {

        MenuMapper mapper = SqlSessionHolder.value.get().getMapper(MenuMapper.class);
        return mapper.selectById(id);
    }

    @Override
    public List<Menu> findForUser(Object id) {
        MenuMapper mapper = SqlSessionHolder.value.get().getMapper(MenuMapper.class);
        return mapper.selectMenuForUser(id);
    }
}
