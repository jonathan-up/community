package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.mappers.MenuMapper;
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

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        String s = menuMapper.selectPermsForUser(1);
        String[] perms = s.split(",");
        for (String perm : perms) {
            System.out.println("perm = " + perm);
        }

        sqlSession.close();
    }
}
