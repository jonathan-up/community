package cn.j0n4than.ex.community.services;

import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.Role;

import java.util.List;

public interface RoleService {

    Page<Role> findPage(Role condition, int current, int size);

    int del(List<Object> ids);

    int insert(List<Role> records);

    int update(Role record);

    Role findOne(Object id);

    int switchStatus(Object id);

    List<Role> findByUserId(Object id);

    int assignRolesToUser(Integer uid, List<Integer> roleIds);

    int assignMenusToRole(Integer rid, List<Integer> menuIds);
}
