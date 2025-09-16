package cn.j0n4than.ex.community.services;

import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.Village;

import java.util.List;

public interface VillageService {

    Page<Village> findPage(String username, int page, int size);

    int del(List<Object> ids);

    int insert(List<Village> records);
}
