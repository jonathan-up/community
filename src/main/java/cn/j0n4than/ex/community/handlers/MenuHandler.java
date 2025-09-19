package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.Page;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.Menu;
import cn.j0n4than.ex.community.pojo.requests.DeleteRequest;
import cn.j0n4than.ex.community.pojo.vo.MenuVo;
import cn.j0n4than.ex.community.pojo.vo.MenusVo;
import cn.j0n4than.ex.community.services.MenuService;
import cn.j0n4than.ex.community.services.impl.MenuServiceImpl;

import java.util.ArrayList;
import java.util.List;

// Menu
public class MenuHandler {

    private final static MenuService menuService = new MenuServiceImpl();

    private static void findChildren(MenusVo parent, List<Menu> records) {
        for (Menu record : records) {
            if (record.getPid().equals(parent.getId())) {
                MenusVo child = new MenusVo(record);
                parent.getChildren().add(child);

                // you are father now
                findChildren(child, records);
            }
        }
    }

    // page list
    public static void page(HttpServletRequestEx request, HttpServletResponseEx response) {

        List<Menu> allRecords = menuService.findAll();

//        ArrayList<MenusVo> top = new ArrayList<>();
//
//        for (Menu record : allRecords) {
//            if (record.getPid() == 0) {
//                MenusVo menusVo = new MenusVo(record);
//                top.add(menusVo);
//                findChildren(menusVo, allRecords);
//            }
//        }

        response.json(200, new ResponseEntity<>("OK", allRecords));
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
