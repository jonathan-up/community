package cn.j0n4than.ex.community.handlers;

import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.Menu;
import cn.j0n4than.ex.community.pojo.vo.MenuVo;
import cn.j0n4than.ex.community.services.MenuService;
import cn.j0n4than.ex.community.services.impl.MenuServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class IndexHandler {

    private final static MenuService menuService = new MenuServiceImpl();

    public static void menu(HttpServletRequestEx request, HttpServletResponseEx response) {

        List<Menu> allMenus = menuService.findForUser(request.getUser().getId());

        // 菜单VO
        ArrayList<MenuVo> topMenus = new ArrayList<>();

        // 顶级菜单
        for (Menu menu : allMenus) {
            if (menu.getType() == 0) {
                topMenus.add(new MenuVo(menu));
            }
        }

        // 二级菜单
        for (Menu menu : allMenus) {
            if (menu.getType() == 1) {
                for (MenuVo topMenu : topMenus) {

                    if (topMenu.getId().equals(menu.getPid())) {
                        topMenu.getChildren().add(menu);
                    }
                }
            }
        }

        response.json(200, new ResponseEntity<>("OK", topMenus));
    }
}
