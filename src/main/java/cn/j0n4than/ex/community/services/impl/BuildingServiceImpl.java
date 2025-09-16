package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.mappers.BuildingMapper;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.vo.BuildingVo;
import cn.j0n4than.ex.community.services.BuildingService;
import cn.j0n4than.ex.community.utils.MybatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;

public class BuildingServiceImpl implements BuildingService {

    @Override
    public Page<BuildingVo> findPage(String name, int current, int size) {
        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            BuildingMapper buildingMapper = sqlSession.getMapper(BuildingMapper.class);
            try (com.github.pagehelper.Page<BuildingVo> pageInfo = PageHelper.startPage(current, size).doSelectPage(() -> buildingMapper.selectByName(name))) {
                Page<BuildingVo> buildingVoPage = new Page<>(current, size);
                buildingVoPage.setTotal((int) pageInfo.getTotal());
                buildingVoPage.setRecords(pageInfo.getResult());

                return buildingVoPage;
            }
        }
    }
}
