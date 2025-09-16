package cn.j0n4than.ex.community.utils;

public class WebUtils {

    public static Integer parseInt(String n, Integer _default) {
        try {
            return Integer.parseInt(n);
        } catch (NumberFormatException e) {
            return _default;
        }
    }

    public static Integer parseInt(String n) {
        return parseInt(n, null);
    }
}
