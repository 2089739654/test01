package controller;

import cn.hutool.crypto.digest.BCrypt;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.LoginService;
import service.LoginServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller()
@RequestMapping("/User")
public class UserController{
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login.do")
    public ModelAndView Login(String username, String password){
        String hashpw = BCrypt.hashpw(password);
        User login = loginService.Login(username);
        ModelAndView mv=new ModelAndView();
        if(login!=null){
            if(BCrypt.checkpw(login.getPassword(),hashpw)){
                mv.addObject("user",login);
                mv.setViewName("index");
                return mv;
            }
        }
        //throw NoUserException;
        return mv;
    }
    @RequestMapping("/logoff.do")
    public ModelAndView Logoff(String username, String password){
        User login = loginService.Login(username);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("qwe");
        if(login!=null){
            String hashpw = BCrypt.hashpw(password);
            if(BCrypt.checkpw(login.getPassword(),hashpw)){
                if(loginService.Logoff(username)==1){
                    return mv;
                }else {
                    //throw NoUserException;
                }
            }
        }
        return mv;
    }
    @RequestMapping("/SignIn.do")
    public ModelAndView SignIn(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword()));
        ModelAndView mv=new ModelAndView();
        if(loginService.SignIn(user)==1){
            mv.setViewName("index");
            mv.addObject("user",user);
            return mv;
        }
        else {
            //throw NoUserException;
            mv.setViewName("welcome");
            return mv;
        }

    }
}
