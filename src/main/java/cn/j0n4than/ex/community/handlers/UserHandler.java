package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.pojo.requests.DeleteRequest;
import cn.j0n4than.ex.community.services.UserService;
import cn.j0n4than.ex.community.services.impl.UserServiceImpl;
import cn.j0n4than.ex.community.utils.Md5Utils;

import java.util.ArrayList;

public class UserHandler {
    private final static UserService userService = new UserServiceImpl();

    public static void page(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer current = request.getParameterInt("page", 1);
        Integer size = request.getParameterInt("size", 10);
        User conditions = request.bindParameter(User.class);

        Page<User> page = userService.findPage(conditions, current, size);
        response.json(200, new ResponseEntity<>("OK", page));
    }

    public static void one(HttpServletRequestEx request, HttpServletResponseEx response) {
        String username = request.getParameter("username");
        User record = userService.findByUsername(username);

        if (record == null) {
            throw new HandlerException(404, "Record not found", null);
        }

        response.json(200, new ResponseEntity<>("OK", record));
    }

    public static void del(HttpServletRequestEx request, HttpServletResponseEx response) {
        DeleteRequest deleteRequest = request.bind(DeleteRequest.class);
        ArrayList<Object> ids = deleteRequest.getIds();

        int count = userService.del(ids);
        response.json(200, new ResponseEntity<>(String.format("成功删除%d条记录", count), ids));
    }

    public static void save(HttpServletRequestEx request, HttpServletResponseEx response) {
        User bind = request.bind(User.class);

        if (bind.getId() == null) {
            // create
            String salt = Md5Utils.crateSalt();
            String pwdEncoded = Md5Utils.md5Password(bind.getPwd(), salt);
            bind.setSalt(salt);
            bind.setPwd(pwdEncoded);

            ArrayList<User> records = new ArrayList<>();
            records.add(bind);
            if (userService.insert(records) > 0) {
                response.json(200, new ResponseEntity<>("添加成功"));
                return;
            }

            response.json(500, new ResponseEntity<>("添加失败"));
            return;
        }

        // update
        if (bind.getPwd() != null && !bind.getPwd().trim().isEmpty()) {
            String salt = Md5Utils.crateSalt();
            String pwdEncoded = Md5Utils.md5Password(bind.getPwd(), salt);
            bind.setSalt(salt);
            bind.setPwd(pwdEncoded);
        }

        if (userService.update(bind) > 0) {
            response.json(200, new ResponseEntity<>("更新成功"));
            return;
        }
        response.json(500, new ResponseEntity<>("更新失败"));
    }

    public static void switchStatus(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer id = request.getParameterInt("id");
        if (id == null) {
            throw new HandlerException(400, "Invalid id", null);
        }

        if (userService.switchStatus(id) > 0) {
            response.json(200, new ResponseEntity<>("更新成功"));
            return;
        }
        response.json(500, new ResponseEntity<>("更新失败"));
    }
}
