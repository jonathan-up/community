package cn.j0n4than.ex.community.filters;

import cn.j0n4than.ex.community.Router;
import cn.j0n4than.ex.community.magic.HttpFilterEx;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.magic.ServletDispatcherCall;
import cn.j0n4than.ex.community.pojo.ResponseEntity;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/api/*")
public class MethodNotAllowedFilter extends HttpFilterEx {

    @Override
    public void doFilter(HttpServletRequestEx request, HttpServletResponseEx response, FilterChain chain) throws IOException, ServletException {
        String method = request.getMethod();
        String pathInfo = request.getPathInfo();

        ServletDispatcherCall handler = Router.getHandler(pathInfo, method);
        if (handler != null) {
            chain.doFilter(request, response);
            return;
        }

        for (String path : Router.getPaths()) {
            String[] p = path.split(" ");
            if (p.length != 2) {
                continue;
            }
            if (p[0].equals(pathInfo) && !p[1].equalsIgnoreCase(method)) {
                response.json(405, new ResponseEntity<>("405 Method Not Allowed"));
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=== MethodNotAllowedFilter::init ====");
    }

    @Override
    public void destroy() {
        System.out.println("=== MethodNotAllowedFilter::destroy ====");
    }
}
