package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.magic.ServletDispatcherCall;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

public class Router {
    private static final HashMap<String, ServletDispatcherCall> routes = new HashMap<>();
    @Getter
    private static final ArrayList<String> paths = new ArrayList<>();

    public static void register(String path, HttpMethod method, ServletDispatcherCall handler) {
        String route = String.format("%s %s", path, method.name());
        if (routes.containsKey(route)) {
            throw new RuntimeException("The route `" + route + "` has already registered!");
        }
        routes.put(route, handler);
        paths.add(route);
    }

    public static ServletDispatcherCall getHandler(String path, String method) {
        return routes.get(String.format("%s %s", path, method));
    }
}
