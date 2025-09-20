package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.handlers.*;

import java.util.Collections;

public class Startup {

    public static void initRouter() {
        Router.register("/auth/login", HttpMethod.POST, AuthHandler::login);
        Router.register("/profile", HttpMethod.GET, ProfileHandler::get);

        Router.register("/index/menu", HttpMethod.GET, IndexHandler::menu);

        // 小区
        Router.register("/village/one", HttpMethod.GET, VillageHandler::one);
        Router.register("/village", HttpMethod.GET, VillageHandler::page, Collections.singletonList("/village/query"));
        Router.register("/village", HttpMethod.PUT, VillageHandler::save, Collections.singletonList("/village/save"));
        Router.register("/village", HttpMethod.DELETE, VillageHandler::del, Collections.singletonList("/village/delete"));
        Router.register("/village/import", HttpMethod.POST, VillageHandler::_import, Collections.singletonList("/village/import"));
        Router.register("/village/upload", HttpMethod.POST, VillageHandler::upload, Collections.singletonList("/village/upload"));

        // 楼栋
        Router.register("/building", HttpMethod.GET, BuildingHandler::page);
        Router.register("/building", HttpMethod.DELETE, BuildingHandler::del);
        Router.register("/building", HttpMethod.PUT, BuildingHandler::save);
        Router.register("/building/one", HttpMethod.GET, BuildingHandler::one);

        // 房屋
        Router.register("/house/one", HttpMethod.GET, HouseHandler::one);
        Router.register("/house", HttpMethod.GET, HouseHandler::page);
        Router.register("/house", HttpMethod.PUT, HouseHandler::save);
        Router.register("/house", HttpMethod.DELETE, HouseHandler::del);

        // user
        Router.register("/user/one", HttpMethod.GET, UserHandler::one);
        Router.register("/user", HttpMethod.GET, UserHandler::page);
        Router.register("/user", HttpMethod.DELETE, UserHandler::del);
        Router.register("/user", HttpMethod.PUT, UserHandler::save);
        Router.register("/user/switchStatus", HttpMethod.PUT, UserHandler::switchStatus);
        Router.register("/user/assignRoles", HttpMethod.POST, UserHandler::assignRoles);

        // role
        Router.register("/role/one", HttpMethod.GET, RoleHandler::one);
        Router.register("/role", HttpMethod.GET, RoleHandler::page);
        Router.register("/role", HttpMethod.PUT, RoleHandler::save);
        Router.register("/role", HttpMethod.DELETE, RoleHandler::del);
        Router.register("/role/switchStatus", HttpMethod.PUT, RoleHandler::switchStatus);
        Router.register("/role/user", HttpMethod.GET, RoleHandler::user);
        Router.register("/role/assignMenus", HttpMethod.POST, RoleHandler::assignMenus);

        // menu
        Router.register("/menu/one", HttpMethod.GET, MenuHandler::one);
        Router.register("/menu/tree", HttpMethod.GET, MenuHandler::tree);
        Router.register("/menu/role", HttpMethod.GET, MenuHandler::role);
        Router.register("/menu", HttpMethod.GET, MenuHandler::page);
        Router.register("/menu", HttpMethod.PUT, MenuHandler::save);
        Router.register("/menu", HttpMethod.DELETE, MenuHandler::del);
    }
}
