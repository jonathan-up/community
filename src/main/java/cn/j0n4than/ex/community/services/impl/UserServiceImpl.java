package cn.j0n4than.ex.community.services.impl;

import cn.j0n4than.ex.community.mappers.UserMapper;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.services.UserService;
import cn.j0n4than.ex.community.utils.Md5Utils;
import cn.j0n4than.ex.community.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) {

        try (
                SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession()
        ) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectByUsername(username);
            if (user == null) {
                return null;
            }

            if (!Md5Utils.checkPassword(password, user.getPassword(), user.getSalt())) {
                return null;
            }

            return user;
        }
    }
}
