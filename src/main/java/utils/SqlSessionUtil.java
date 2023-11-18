package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import sun.misc.Resource;

import java.io.IOException;
import java.sql.Connection;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> local=new ThreadLocal<>();

    static {
        try {
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private SqlSessionUtil(){}
    public static SqlSession GetSqlSession(){
        SqlSession sqlSession= local.get();
        if(sqlSession==null){
            sqlSession=sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
            local.remove();
        }
    }

}