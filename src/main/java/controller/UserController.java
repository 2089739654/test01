package controller;

import cn.hutool.crypto.digest.BCrypt;
import exception.FailSignInException;
import exception.NoUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.LoginService;

import javax.servlet.http.HttpSession;


@Controller()
@RequestMapping("/User")
public class UserController{
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login.do")
    public ModelAndView Login(String username, String password,HttpSession session) throws NoUserException {
        User login = loginService.Login(username);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index");
        if(login!=null){
            if(BCrypt.checkpw(password,login.getPassword())){
                session.setAttribute("username",login.getName());
                mv.addObject("user",login);
                mv.setViewName("index");
                return mv;
            }
        }
        throw new NoUserException("登录失败");
    }
    @RequestMapping("/logoff.do")
    public ModelAndView Logoff(String username, String password,HttpSession session) throws FailSignInException {
        User login = loginService.Login(username);
        ModelAndView mv=new ModelAndView();
        if(login!=null){
            if(BCrypt.checkpw(password,login.getPassword())){
                if(loginService.Logoff(username)==1){
                    session.removeAttribute("username");
                    mv.setViewName("welcome");
                    return mv;
                }
            }
        }
        throw new FailSignInException("注销失败");
    }
    @RequestMapping("/SignIn.do")
    public ModelAndView SignIn(User user) throws FailSignInException {
        user.setPassword(BCrypt.hashpw(user.getPassword()));
        ModelAndView mv=new ModelAndView();
        if(loginService.SignIn(user)==1){
            mv.setViewName("index");
            mv.addObject("user",user);
            return mv;
        }
        else {
            throw new FailSignInException("注册失败");
        }

    }
}
