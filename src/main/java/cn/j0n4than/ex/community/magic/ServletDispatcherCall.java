package cn.j0n4than.ex.community.magic;

@FunctionalInterface
public interface ServletDispatcherCall {
    void call(HttpServletRequestEx req, HttpServletResponseEx resp) throws Exception;
}
