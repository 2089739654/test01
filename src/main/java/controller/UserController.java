package controller;

import cn.hutool.crypto.digest.BCrypt;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

@WebServlet({"/User/login","/User/logoff","/User/signin"})
public class UserController extends HttpServlet {

    private  ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
    private  LoginService loginService = applicationContext.getBean("LoginServiceImp", LoginService.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String servletPath = req.getServletPath();
        if("/User/login".equals(servletPath)){
            String id = req.getParameter("username");
            String password = req.getParameter("password");
            String hashpw = BCrypt.hashpw(password);
            User login = loginService.Login(id);
            if(BCrypt.checkpw(login.getPassword(),hashpw)){
                HttpSession httpSession= req.getSession(false);
                httpSession.setAttribute("username",id);
                resp.sendRedirect(req.getContextPath()+"/index.jsp");

            }else{
                resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
            }
        } else if ("/User/logoff".equals(servletPath)) {
            String id = req.getParameter("username");
            String password = req.getParameter("password");
            String hashpw = BCrypt.hashpw(password);
            User login = loginService.Login(id);
            if(BCrypt.checkpw(password,login.getPassword())){
                int logoff = loginService.Logoff(id);
                if(logoff==1){
                    resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
                }else {
                    //异常处理
                }
            }else {
                resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
            }

        } else if ("/User/signin".equals(servletPath)) {
            String name= req.getParameter("name");
            String id = req.getParameter("username");
            String password = BCrypt.hashpw(req.getParameter("password"));
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            User user=new User(null,name,id,phone,address,password);
            int counter = loginService.SignIn(user);
            if(counter==1){
                resp.sendRedirect(req.getContextPath()+"/signin.jsp");
            }else {
                //异常处理
            }
        }else {
            resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
        }
    }
}
