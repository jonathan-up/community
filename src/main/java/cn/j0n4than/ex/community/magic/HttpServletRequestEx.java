package cn.j0n4than.ex.community.magic;

import cn.j0n4than.ex.community.AuthUserHolder;
import cn.j0n4than.ex.community.exceptions.HandlerException;
import cn.j0n4than.ex.community.pojo.entities.User;
import cn.j0n4than.ex.community.utils.WebUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class HttpServletRequestEx extends HttpServletRequestWrapper {

    private final static int MAX_BUFFER_SIZE = 1024;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */
    public HttpServletRequestEx(HttpServletRequest request) {
        super(request);
    }

    /**
     * Bind json to object
     *
     * @param t target type
     * @return target type's instance
     * @throws HandlerException BAD REQUEST
     */
    public <T> T bind(Class<T> t) throws HandlerException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ServletInputStream inputStream = this.getInputStream();
            byte[] buffer = new byte[MAX_BUFFER_SIZE];
            int len = inputStream.read(buffer);

            String body = new String(buffer, 0, len);
            return objectMapper.readValue(body, t);
        } catch (JsonParseException e) {
            throw new HandlerException(400, "Bad Request", e.getMessage());
        } catch (IOException e) {
            System.out.println("ERR: " + e.getMessage());
        }
        return null;
    }

    /**
     * Get logon user
     * it is parsed from token by AuthFilter
     *
     * @return User
     */
    public User getUser() {
        return AuthUserHolder.value.get();
    }

    public Integer getParameterInt(String key) {
        return this.getParameterInt(key, null);
    }
    public Integer getParameterInt(String key, Integer _default) {
        String parameter = this.getParameter(key);
        return WebUtils.parseInt(parameter, _default);
    }
}
