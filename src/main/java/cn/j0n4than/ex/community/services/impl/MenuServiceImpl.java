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
    public Page<Menu> findPage(Menu condition, int current, int size) {

        MenuMapper mapper = SqlSessionHolder.value.get().getMapper(MenuMapper.class);
        try (com.github.pagehelper.Page<Menu> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> mapper.select(condition))) {
            Page<Menu> thePage = new Page<>(current, size);
            thePage.setTotal((int) pageInfo.getTotal());
            thePage.setRecords(pageInfo.getResult());

            return thePage;
        }
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
