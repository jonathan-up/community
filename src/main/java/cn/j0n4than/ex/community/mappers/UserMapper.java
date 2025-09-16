package cn.j0n4than.ex.community.mappers;

import cn.j0n4than.ex.community.pojo.entities.User;

public interface UserMapper {

    User selectByUsername(String username);
}
