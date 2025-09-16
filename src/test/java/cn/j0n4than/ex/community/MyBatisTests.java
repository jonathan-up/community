package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.mappers.BuildingMapper;
import cn.j0n4than.ex.community.pojo.vo.BuildingVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTests {

    @Test
    void test() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(is);

        SqlSession sqlSession = sessionFactory.openSession();

        BuildingMapper buildingMapper = sqlSession.getMapper(BuildingMapper.class);

        List<BuildingVo> buildingVos = buildingMapper.selectByName(null);
        System.out.println("buildingVos = " + buildingVos);

        sqlSession.close();
    }
}
