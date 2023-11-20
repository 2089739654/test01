package service;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import utils.SqlSessionUtil;



@Transactional
@Service("LoginServiceImp")
public class LoginServiceImp implements LoginService{
    @Autowired
    private UserMapper mapper;

    public User Login(String id) {
        return mapper.selectById(id);
    }

    public int SignIn(User user) {
        return mapper.insert(user);
    }

    public int Logoff(String id) {
        return mapper.deleteById(id);
    }
}
