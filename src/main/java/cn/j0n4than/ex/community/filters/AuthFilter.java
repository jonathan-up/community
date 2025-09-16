package cn.j0n4than.ex.community.filters;

import cn.j0n4than.ex.community.AuthUserHolder;
import cn.j0n4than.ex.community.magic.HttpFilterEx;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@WebFilter("/api/*")
public class AuthFilter extends HttpFilterEx {

    private List<String> excludePaths;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=== AuthFilter::init ====");
        try (InputStream iStream = this.getClass().getClassLoader().getResourceAsStream("auth.properties");) {
            Properties props = new Properties();
            props.load(iStream);
            String[] paths = props.getProperty("auth.excludesPath").split(",");
            excludePaths = Arrays.asList(paths);
        } catch (IOException e) {
            System.out.println("ERR: " + e.getMessage());
            System.out.println("Using default exclude paths");
            String[] excludes = {"/auth/login"};
            excludePaths = Arrays.asList(excludes);
        }
    }

    @Override
    public void doFilter(HttpServletRequestEx request, HttpServletResponseEx response, FilterChain chain) throws IOException, ServletException {

        // excludes
        String uri = request.getRequestURI();
        for (String exclude : this.excludePaths) {
            if (uri.contains(exclude)) {
                // go ahead
                chain.doFilter(request, response);
                return;
            }
        }

        // Check login state
        String token = request.getHeader("Authorization");
        ResponseEntity<Object> responseEntity = new ResponseEntity<>("401 未授权");
        try {
            User user = JwtUtils.parse(token, User.class);

            AuthUserHolder.value.set(user);
            chain.doFilter(request, response);
            AuthUserHolder.value.remove();
            return;
        } catch (ExpiredJwtException e) {
            // expired token
            responseEntity = new ResponseEntity<>("登录状态失效");
        } catch (Exception e) {
            System.out.println("ERR: " + e.getMessage());
        }

        response.json(401, responseEntity);
    }

    @Override
    public void destroy() {
        System.out.println("=== AuthFilter::destroy ====");
    }
}
