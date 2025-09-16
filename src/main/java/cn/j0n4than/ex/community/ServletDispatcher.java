package cn.j0n4than.ex.community;

import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.magic.ServletDispatcherCall;
import cn.j0n4than.ex.community.pojo.ResponseEntity;
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

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
@WebServlet(name = "dispatcher", urlPatterns = "/api/*", loadOnStartup = 1)
public class ServletDispatcher extends HttpServlet {

    private void callHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String path = req.getPathInfo();
            String method = req.getMethod();

            // Get handler from routes
            ServletDispatcherCall handler = Router.getHandler(path, method);

            // Handler not found
            if (handler == null) {
                throw new HandlerException(404, "404 Not Found", null);
            }

            // TODO: middleware? filter?

            // Call handler
            handler.call(new HttpServletRequestEx(req), new HttpServletResponseEx(resp));
        } catch (HandlerException e) {
            new HttpServletResponseEx(resp)
                    .json(e.getHttpStatus(), new ResponseEntity<>(e.getMessage(), e.getResult()));
        } catch (Exception e) {
            new HttpServletResponseEx(resp)
                    .json(500, new ResponseEntity<>("500 Server Internal Error", e.getMessage()));
        }
    }

    public ServletDispatcher() {
        System.out.println("===ServletDispatcher::ServletDispatcher()");
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
