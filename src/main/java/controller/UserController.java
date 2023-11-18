package controller;

import org.junit.Test;
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        System.out.println(servletPath);
        if("/User/login".equals(servletPath)){
            String id = req.getParameter("username");
            String password = req.getParameter("password");
            LoginService loginService=new LoginServiceImp();
            int counter = loginService.Login(id, Integer.parseInt(password));
            if(counter==1){
                HttpSession httpSession= req.getSession(false);
                httpSession.setAttribute("username",id);
                resp.sendRedirect(req.getContextPath()+"/index.jsp");

            }else{

                resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
            }
        } else if ("/User/logoff".equals(servletPath)) {
            String id = req.getParameter("username");
            String password = req.getParameter("password");
            LoginService loginService=new LoginServiceImp();
            int counter = loginService.Logoff(id, Integer.parseInt(password));
            if(counter==1){
                resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
            }else {

                resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
            }

        } else if ("/User/signin".equals(servletPath)) {
            resp.sendRedirect(req.getContextPath()+"/signin.jsp");
        }else {
            resp.sendRedirect(req.getContextPath()+"/welcome.jsp");
        }
    }
}
