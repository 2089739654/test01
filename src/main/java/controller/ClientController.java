package controller;

import exception.ClientException;
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
        mv.addObject("client",client);
        return mv;
    }
    @RequestMapping("/add.do")
    public ModelAndView AddClient(Client client) throws ClientException {
        ModelAndView mv=new ModelAndView();
        if(clientService.AddClient(client)==1){
            mv.setViewName("result");
            return mv;
        }else {
            throw new ClientException("添加失败");
        }
    }



}
