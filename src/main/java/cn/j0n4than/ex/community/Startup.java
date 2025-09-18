package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.handlers.*;

public class Startup {

    public static void initRouter() {
        Router.register("/auth/login", HttpMethod.POST, AuthHandler::login);
        Router.register("/profile", HttpMethod.GET, ProfileHandler::get);

        // 小区
        Router.register("/village/one", HttpMethod.GET, VillageHandler::one);
        Router.register("/village", HttpMethod.GET, VillageHandler::page);
        Router.register("/village", HttpMethod.PUT, VillageHandler::save);
        Router.register("/village", HttpMethod.DELETE, VillageHandler::del);
        Router.register("/village/import", HttpMethod.POST, VillageHandler::_import);
        Router.register("/village/upload", HttpMethod.POST, VillageHandler::upload);

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


        // role
        Router.register("/role/one", HttpMethod.GET, RoleHandler::one);
        Router.register("/role", HttpMethod.GET, RoleHandler::page);
        Router.register("/role", HttpMethod.PUT, RoleHandler::save);
        Router.register("/role", HttpMethod.DELETE, RoleHandler::del);
        Router.register("/role/switchStatus", HttpMethod.PUT, RoleHandler::switchStatus);
        Router.register("/role/user", HttpMethod.GET, RoleHandler::user);
    }
}
