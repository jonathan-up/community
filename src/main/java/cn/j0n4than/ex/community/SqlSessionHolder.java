package cn.j0n4than.ex.community;

import org.apache.ibatis.session.SqlSession;

public class SqlSessionHolder {
    public static ThreadLocal<SqlSession> value = new ThreadLocal<>();
}
