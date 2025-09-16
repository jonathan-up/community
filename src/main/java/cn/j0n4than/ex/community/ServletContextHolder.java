package cn.j0n4than.ex.community;

import javax.servlet.ServletContext;

public class ServletContextHolder {
    public static ThreadLocal<ServletContext> value = new ThreadLocal<>();
}
