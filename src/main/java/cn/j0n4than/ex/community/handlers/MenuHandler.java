package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.Menu;
import cn.j0n4than.ex.community.pojo.requests.DeleteRequest;
import cn.j0n4than.ex.community.services.MenuService;
import cn.j0n4than.ex.community.services.impl.MenuServiceImpl;

import java.util.ArrayList;

// Menu
public class MenuHandler {

    private final static MenuService menuService = new MenuServiceImpl();

    // page list
    public static void page(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer current = request.getParameterInt("page", 1);
        Integer size = request.getParameterInt("size", 10);
        Menu condition = request.bindParameter(Menu.class);

        Page<Menu> page = menuService.findPage(condition, current, size);
        response.json(200, new ResponseEntity<>("OK", page));
    }

    // get one
    public static void one(HttpServletRequestEx request, HttpServletResponseEx response) {
        Integer id = request.getParameterInt("id");
        if (id == null) {
            throw new HandlerException(400, "Invalid id", null);
        }

        Menu one = menuService.findOne(id);
        if (one == null) {
            throw new HandlerException(404, "Record not found", null);
        }

        response.json(200, new ResponseEntity<>("OK", one));
    }

    // create or update
    public static void save(HttpServletRequestEx request, HttpServletResponseEx response) {

        Menu bind = request.bind(Menu.class);
        if (bind.getId() == null) {
            // create
            ArrayList<Menu> data = new ArrayList<>();
            data.add(bind);
            if (menuService.insert(data) > 0) {
                response.json(200, new ResponseEntity<>("添加成功"));
                return;
            }

            response.json(500, new ResponseEntity<>("添加失败"));
            return;
        }

        // update
        if (menuService.update(bind) > 0) {
            response.json(200, new ResponseEntity<>("更新成功"));
            return;
        }
        response.json(500, new ResponseEntity<>("更新失败"));
    }

    // delete
    public static void del(HttpServletRequestEx request, HttpServletResponseEx response) {
        DeleteRequest deleteRequest = request.bind(DeleteRequest.class);
        ArrayList<Object> ids = deleteRequest.getIds();

        int count = menuService.del(ids);
        response.json(200, new ResponseEntity<>(String.format("成功删除%d条记录", count), ids));
    }
}
