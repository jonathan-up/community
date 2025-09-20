package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.handlers.MenuHandler;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
@WebServlet(name = "dispatcher", urlPatterns = "/api/*", loadOnStartup = 1)
public class ServletDispatcher extends HttpServlet {

    public ServletDispatcher() {
        System.out.println("===ServletDispatcher::ServletDispatcher()");
    }

    private void callHandler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String path = req.getPathInfo();
            String method = req.getMethod();

            // Get handler from routes
            Route route = Router.getRoute(path, method);

            // Handler not found
            if (route == null) {
                throw new HandlerException(404, "404 Not Found", null);
            }

            // Permissions
            List<String> routePerms = route.getPerms();
            if (routePerms.isEmpty()) {
                // Call handler
                route.getHandler().call(new HttpServletRequestEx(req), new HttpServletResponseEx(resp));
                return;
            }

            List<String> userPerms = Collections.emptyList();
            User user = AuthUserHolder.value.get();
            if (user != null) {
                userPerms = MenuHandler.menuService.findPermissions(user.getId());
            }

            if (new HashSet<>(userPerms).containsAll(routePerms)) {
                route.getHandler().call(new HttpServletRequestEx(req), new HttpServletResponseEx(resp));
                return;
            }

            throw new HandlerException(403, "403 Forbidden", null);
        } catch (HandlerException e) {
            new HttpServletResponseEx(resp)
                    .json(e.getHttpStatus(), new ResponseEntity<>(e.getMessage(), e.getResult()));
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            new HttpServletResponseEx(resp)
                    .json(500, new ResponseEntity<>("500 Server Internal Error", e.getMessage()));

            // for sql filter rollback
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("===ServletDispatcher::service()");
        this.callHandler(req, res);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("===ServletDispatcher::init()");
        SqlSession sqlSession = MybatisUtils.sqlSessionFactory.openSession();
        Connection connection = sqlSession.getConnection();
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        sqlSession.close();
        Startup.initRouter();
    }

    @Override
    public void destroy() {
        System.out.println("===ServletDispatcher::destroy()");
        super.destroy();
    }
}
