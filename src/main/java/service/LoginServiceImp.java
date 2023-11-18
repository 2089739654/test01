package service;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.User;
import utils.SqlSessionUtil;

public class LoginServiceImp implements LoginService{


    public int Login(String id, Integer password) {
        SqlSession sqlSession= SqlSessionUtil.GetSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int counter=mapper.selectByIdPassword(id,password);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return counter;
    }

    public int SignIn(User user) {
        SqlSession sqlSession=SqlSessionUtil.GetSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int counter = mapper.insert(user);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return counter;
    }

    public int Logoff(String id, Integer password) {
        SqlSession sqlSession=SqlSessionUtil.GetSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int counter = mapper.deleteByIdPassword(id, password);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return counter;
    }
}
