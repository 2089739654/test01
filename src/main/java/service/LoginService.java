package service;

import pojo.User;

public interface LoginService {
    public User Login(String id);
    public int SignIn(User user);
    public int Logoff(String id);

}
