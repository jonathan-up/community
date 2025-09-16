package cn.j0n4than.ex.community.filters;

import cn.j0n4than.ex.community.ServletContextHolder;
import cn.j0n4than.ex.community.magic.HttpFilterEx;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class ServletContextHolderFilter extends HttpFilterEx {
    @Override
    protected void doFilter(HttpServletRequestEx request, HttpServletResponseEx response, FilterChain chain) throws ServletException, IOException {
        ServletContextHolder.value.set(request.getServletContext());
        chain.doFilter(request, response);
        ServletContextHolder.value.remove();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=== ServletContextHolderFilter::init ====");
    }

    @Override
    public void destroy() {
        System.out.println("=== ServletContextHolderFilter::destroy ====");
    }
}
