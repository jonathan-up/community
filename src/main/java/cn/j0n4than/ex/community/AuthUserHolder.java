package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.pojo.entities.User;

public class AuthUserHolder {
    public static ThreadLocal<User> value = new ThreadLocal<>();
}
