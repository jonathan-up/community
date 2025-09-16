package cn.j0n4than.ex.community.magic;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class HttpServletResponseEx extends HttpServletResponseWrapper {
    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response the {@link HttpServletResponse} to be wrapped.
     * @throws IllegalArgumentException if the response is null
     */
    public HttpServletResponseEx(HttpServletResponse response) {
        super(response);
    }

    public <T> void json(int status, T obj) {
        this.setContentType("application/json;charset=utf8");
        this.setStatus(status);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(obj);
            this.getWriter().println(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
