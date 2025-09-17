package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.mappers.HouseMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.entities.House;
import cn.j0n4than.ex.community.pojo.vo.HouseVo;
import cn.j0n4than.ex.community.services.HouseService;
import cn.j0n4than.ex.community.utils.MybatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HouseServiceImpl implements HouseService {

    @Override
    public Page<HouseVo> findPage(HouseVo condition, int current, int size) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
            try (com.github.pagehelper.Page<HouseVo> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> mapper.select(condition))) {
                Page<HouseVo> thePage = new Page<>(current, size);
                thePage.setTotal((int) pageInfo.getTotal());
                thePage.setRecords(pageInfo.getResult());

                return thePage;
            }
        }
    }

    @Override
    public int del(List<Object> ids) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
            int count = mapper.deleteByIds(ids);
            sqlSession.commit();
            return count;
        }
    }

    @Override
    public int insert(List<House> records) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
            int count = mapper.insertBatch(records);
            sqlSession.commit();
            return count;
        }
    }

    @Override
    public int update(House record) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
            int count = mapper.updateOne(record);
            sqlSession.commit();
            return count;
        }
    }

    @Override
    public House findOne(Object id) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
            return mapper.selectById(id);
        }
    }
}
