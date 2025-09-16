package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.mappers.VillageMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.Village;
import cn.j0n4than.ex.community.services.VillageService;
import cn.j0n4than.ex.community.utils.MybatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class VillageServiceImpl implements VillageService {
    @Override
    public Page<Village> findPage(String name, int current, int size) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            VillageMapper villageMapper = sqlSession.getMapper(VillageMapper.class);
            try (com.github.pagehelper.Page<Village> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> villageMapper.selectByName(name))) {
                Page<Village> villagePage = new Page<>(current, size);
                villagePage.setTotal((int) pageInfo.getTotal());
                villagePage.setRecords(pageInfo.getResult());

                return villagePage;
            }
        }
    }

    @Override
    public int del(List<Object> ids) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            VillageMapper villageMapper = sqlSession.getMapper(VillageMapper.class);
            int count = villageMapper.deleteByIds(ids);
            sqlSession.commit();
            return count;
        }
    }

    @Override
    public int insert(List<Village> records) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            VillageMapper villageMapper = sqlSession.getMapper(VillageMapper.class);
            int count = villageMapper.insertBatch(records);
            sqlSession.commit();
            return count;
        }
    }
}
