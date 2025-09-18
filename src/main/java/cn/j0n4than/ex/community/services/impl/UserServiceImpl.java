package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.SqlSessionHolder;
import cn.j0n4than.ex.community.mappers.UserMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.services.UserService;
import cn.j0n4than.ex.community.utils.Md5Utils;
import com.github.pagehelper.PageHelper;

import java.util.List;

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

    @Override
    public Page<User> findPage(User condition, int current, int size) {
        UserMapper mapper = SqlSessionHolder.value.get().getMapper(UserMapper.class);

        try (com.github.pagehelper.Page<User> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> mapper.select(condition))) {
            Page<User> thePage = new Page<>(current, size);
            thePage.setTotal((int) pageInfo.getTotal());
            thePage.setRecords(pageInfo.getResult());

            return thePage;
        }
    }

    @Override
    public User findByUsername(String username) {
        UserMapper mapper = SqlSessionHolder.value.get().getMapper(UserMapper.class);
        return mapper.selectByUsername(username);
    }

    @Override
    public int del(List<Object> ids) {
        UserMapper mapper = SqlSessionHolder.value.get().getMapper(UserMapper.class);
        return mapper.deleteByIds(ids);
    }

    @Override
    public int insert(List<User> records) {
        UserMapper mapper = SqlSessionHolder.value.get().getMapper(UserMapper.class);
        return mapper.insertBatch(records);
    }

    @Override
    public int update(User record) {
        UserMapper mapper = SqlSessionHolder.value.get().getMapper(UserMapper.class);
        return mapper.updateOne(record);
    }

    @Override
    public int switchStatus(Object id) {
        UserMapper mapper = SqlSessionHolder.value.get().getMapper(UserMapper.class);
        return mapper.switchStatus(id);
    }
}
