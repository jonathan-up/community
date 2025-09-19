package cn.j0n4than.ex.community.services;

import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> findAll();

    int del(List<Object> ids);

    int insert(List<Menu> records);

    int update(Menu record);

    Menu findOne(Object id);

    List<Menu> findForUser(Object id);
}
