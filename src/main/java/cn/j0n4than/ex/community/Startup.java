package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.handlers.AuthHandler;
import cn.j0n4than.ex.community.handlers.ProfileHandler;
import cn.j0n4than.ex.community.handlers.VillageHandler;

public class Startup {

    public static void initRouter() {
        Router.register("/auth/login", HttpMethod.POST, AuthHandler::login);
        Router.register("/profile", HttpMethod.GET, ProfileHandler::get);

        // 小区
        Router.register("/village", HttpMethod.GET, VillageHandler::page);
        Router.register("/village", HttpMethod.PUT, VillageHandler::save);
        Router.register("/village", HttpMethod.DELETE, VillageHandler::del);
        Router.register("/village/import", HttpMethod.POST, VillageHandler::_import);
        Router.register("/village/upload", HttpMethod.POST, VillageHandler::upload);
    }
}
