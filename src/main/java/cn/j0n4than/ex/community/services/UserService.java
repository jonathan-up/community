package cn.j0n4than.ex.community.services;

import cn.j0n4than.ex.community.pojo.entities.User;

public interface UserService {

    User login(String username, String password);
}
