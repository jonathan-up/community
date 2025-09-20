package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.pojo.requests.LoginRequest;
import cn.j0n4than.ex.community.pojo.response.LoginResponse;
import cn.j0n4than.ex.community.services.MenuService;
import cn.j0n4than.ex.community.services.UserService;
import cn.j0n4than.ex.community.services.impl.MenuServiceImpl;
import cn.j0n4than.ex.community.services.impl.UserServiceImpl;
import cn.j0n4than.ex.community.utils.JwtUtils;
import cn.j0n4than.ex.community.utils.TimeUtils;

import java.util.List;

public class AuthHandler {

    private final static UserService userService;
    private final static MenuService menuService;

    static {
        userService = new UserServiceImpl();
        menuService = new MenuServiceImpl();
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
        user.setPwd(null);
        user.setSalt(null);
        String token = JwtUtils.crete(user, TimeUtils.HOUR * 10);

        // Find his permissions
        List<String> permissions = menuService.findPermissions(user.getId());
        LoginResponse loginResponse = new LoginResponse(token, permissions);

        response.json(200, new ResponseEntity<>("登录成功", loginResponse));
    }
}
