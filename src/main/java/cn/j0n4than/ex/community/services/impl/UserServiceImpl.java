package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.SqlSessionHolder;
import cn.j0n4than.ex.community.mappers.UserMapper;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.services.UserService;
import cn.j0n4than.ex.community.utils.Md5Utils;

public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) {

        UserMapper mapper = SqlSessionHolder.value.get().getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        if (user == null) {
            return null;
        }

        if (!Md5Utils.checkPassword(password, user.getPwd(), user.getSalt())) {
            return null;
        }

        return user;
    }
}
