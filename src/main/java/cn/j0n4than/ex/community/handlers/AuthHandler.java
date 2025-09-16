package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.pojo.requests.LoginRequest;
import cn.j0n4than.ex.community.services.UserService;
import cn.j0n4than.ex.community.services.impl.UserServiceImpl;
import cn.j0n4than.ex.community.utils.JwtUtils;
import cn.j0n4than.ex.community.utils.TimeUtils;

public class AuthHandler {

    private final static UserService userService;

    static {
        userService = new UserServiceImpl();
    }

    public static void login(HttpServletRequestEx request, HttpServletResponseEx response) {

        // Get request body
        LoginRequest loginRequest = request.bind(LoginRequest.class);

        User user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            response.json(500, new ResponseEntity<>("用户名或密码错误"));
            return;
        }

        // SOME LOGON STUFF...
        // Generate a token?
        user.setPassword(null);
        user.setSalt(null);
        String token = JwtUtils.crete(user, TimeUtils.HOUR * 10);

        response.json(200, new ResponseEntity<>("登录成功", token));
    }
}
