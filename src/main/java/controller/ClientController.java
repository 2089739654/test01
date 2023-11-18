package controller;

import pojo.Client;
import service.ClientService;
import service.ClientServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/Client/t1","",""})
public class ClientController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientService clientService=new ClientServiceImp();
        String servletPath = req.getServletPath();
        req.setCharacterEncoding("UTF-8");
        if("/Client/t1".equals(servletPath)){
            String name=req.getParameter("name");
            String phone=req.getParameter("phone");
            String identity=req.getParameter("identity");
            String id=req.getParameter("id");
            String company=req.getParameter("company");
            Client client=new Client(null,name,phone,identity,id,company);
            int counter = clientService.AddClient(client);

        } else if ("/Client/t2".equals(servletPath)) {
            String name=req.getParameter("name");
            String phone=req.getParameter("phone");
            String identity=req.getParameter("identity");
            Client client = clientService.QueryClient(identity, name, phone);
            req.setAttribute("client",client);
            req.getRequestDispatcher("").forward(req,resp);
        }


    }
}
