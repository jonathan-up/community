package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.utils.JwtUtils;
import cn.j0n4than.ex.community.utils.TimeUtils;
import org.junit.jupiter.api.Test;

public class JwtTests {

    @Test
    void test() throws InterruptedException {
        User user = new User();
        user.setUsername("H0meV");
        String token = JwtUtils.crete(user, TimeUtils.SEC * 3);
        System.out.println("token = " + token);

        Thread.sleep(TimeUtils.SEC * 5);

        User c = JwtUtils.parse(token, User.class);
        System.out.println("c = " + c);
    }
}
