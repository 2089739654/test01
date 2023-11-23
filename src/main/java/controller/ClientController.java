package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Client;
import service.ClientService;
import service.ClientServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller()
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @RequestMapping("/query.do")
    public ModelAndView QueryClient(String identity,String phone,String name){
        Client client = clientService.QueryClient(identity, name, phone);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("result");
        if(client!=null){
            mv.addObject("client",client);
            return mv;
        }else {
            //throw
            return mv;
        }

    }
    @RequestMapping("/add.do")
    public ModelAndView AddClient(Client client){
        ModelAndView mv=new ModelAndView();
        if(clientService.AddClient(client)==1){
            mv.setViewName("result");
            return mv;
        }else {
            //throw
            return mv;
        }
    }



}
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ClientService clientService=new ClientServiceImp();
//        String servletPath = req.getServletPath();
//        req.setCharacterEncoding("UTF-8");
//        if("/Client/t1".equals(servletPath)){
//            String name=req.getParameter("name");
//            String phone=req.getParameter("phone");
//            String identity=req.getParameter("identity");
//            String id=req.getParameter("id");
//            String company=req.getParameter("company");
//            Client client=new Client(null,name,phone,identity,id,company);
//            int counter = clientService.AddClient(client);
//
//        } else if ("/Client/t2".equals(servletPath)) {
//            String name=req.getParameter("name");
//            String phone=req.getParameter("phone");
//            String identity=req.getParameter("identity");
//            Client client = clientService.QueryClient(identity, name, phone);
//            req.setAttribute("client",client);
//            req.getRequestDispatcher("").forward(req,resp);
//        }
//
//
//    }