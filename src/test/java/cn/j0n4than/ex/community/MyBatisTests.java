package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.mappers.UserMapper;
import cn.j0n4than.ex.community.pojo.entities.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class MyBatisTests {

    @Test
    void test() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(is);

        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectByUsername("H0meV");
        System.out.println("user = " + user);

        sqlSession.close();
    }
}
