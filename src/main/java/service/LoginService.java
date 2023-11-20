package service;

import pojo.User;

public interface LoginService {
    public int Login(String id,Integer password);
    public int SignIn(User user);
    public int Logoff(String id,Integer password);



}
