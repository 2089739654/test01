package controller;

import service.ClientService;
import service.ClientServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/Client/","",""})
public class ClientController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientService clientService=new ClientServiceImp();
        String servletPath = req.getServletPath();
        req.setCharacterEncoding("UTF-8");


    }
}
