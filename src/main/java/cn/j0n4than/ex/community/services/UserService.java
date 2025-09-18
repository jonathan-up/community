package cn.j0n4than.ex.community.services;

import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.User;

import java.util.List;

public interface UserService {

    User login(String username, String password);

    Page<User> findPage(User condition, int page, int size);

    User findByUsername(String username);

    int del(List<Object> ids);

    int insert(List<User> records);

    int update(User record);

    int switchStatus(Object id);
}
