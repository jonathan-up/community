package cn.j0n4than.ex.community.magic;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class HttpFilterEx implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.doFilter(new HttpServletRequestEx((HttpServletRequest) request), new HttpServletResponseEx((HttpServletResponse) response), chain);
    }

    protected void doFilter(HttpServletRequestEx request, HttpServletResponseEx response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
