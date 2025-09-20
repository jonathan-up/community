package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.magic.ServletDispatcherCall;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Router {
    private static final HashMap<String, Route> routes = new HashMap<>();
    @Getter
    private static final ArrayList<String> paths = new ArrayList<>();

    public static void register(String path, HttpMethod method, ServletDispatcherCall handler, List<String> perms) {
        String route = String.format("%s %s", path, method.name());
        if (routes.containsKey(route)) {
            throw new RuntimeException("The route `" + route + "` has already registered!");
        }
        Route r = new Route(method, perms, handler);
        routes.put(route, r);
        paths.add(route);
    }

    public static void register(String path, HttpMethod method, ServletDispatcherCall handler) {
        register(path, method, handler, Collections.emptyList());
    }

    public static Route getRoute(String path, String method) {
        return routes.get(String.format("%s %s", path, method));
    }
}
