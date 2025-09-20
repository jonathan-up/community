package cn.j0n4than.ex.community.filters;

import cn.j0n4than.ex.community.SqlSessionHolder;
import cn.j0n4than.ex.community.magic.HttpFilterEx;
import cn.j0n4than.ex.community.magic.HttpServletRequestEx;
import cn.j0n4than.ex.community.magic.HttpServletResponseEx;
import cn.j0n4than.ex.community.utils.MybatisUtils;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class SqlSessionHolderFilter extends HttpFilterEx {
    @Override
    protected void doFilter(HttpServletRequestEx request, HttpServletResponseEx response, FilterChain chain) throws ServletException, IOException {
        // open session
        SqlSessionHolder.value.set(MybatisUtils.sqlSessionFactory.openSession());

        try {
            chain.doFilter(request, response);

            // Commit
            SqlSessionHolder.value.get().commit();
        } catch (Exception e) {
            // Rollback
            SqlSessionHolder.value.get().rollback();
        } finally {
            // Finally close & remove it
            SqlSessionHolder.value.get().close();
            SqlSessionHolder.value.remove();
        }
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
