package controller;

import mapper.PortMapper;
import org.apache.ibatis.session.SqlSession;
import service.ImOutService;
import service.ImOutServiceImp;
import utils.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


@WebServlet({"/Port/t1","/Port/t2","/Port/t3","/Port/t4"})
public class PortController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        ImOutService imOutService=new ImOutServiceImp();
        req.setCharacterEncoding("UTF-8");
        if("/Port/t1".equals(servletPath)){
            String name = req.getParameter("name");
            String dateOn = req.getParameter("dateOn");
            String dateOff = req.getParameter("dateOff");
            int[] result = imOutService.SelectNum(name, dateOn, dateOff);
            req.setAttribute("result",result);
            req.getRequestDispatcher("/port1.jsp").forward(req,resp);
        }else if("/Port/t2".equals(servletPath)){
            String name = req.getParameter("name");
            String dateOn = req.getParameter("dateOn");
            String dateOff = req.getParameter("dateOff");
            String id=req.getParameter("id");
            Map<String, Integer[]> result = imOutService.QueryGoods(name, dateOn, dateOff, id);
            req.setAttribute("result",result);
            req.getRequestDispatcher("/port2.jsp").forward(req,resp);
        } else if ("/Port/t3".equals(servletPath)) {
            String id=req.getParameter("id");
            Map<String, Integer[]> result = imOutService.QueryLogistics(id);
            req.setAttribute("result",result);
            req.getRequestDispatcher("/Port3.jsp").forward(req,resp);

        } else if ("/Port/t4".equals(servletPath)) {
            String name = req.getParameter("name");
            String dateOn = req.getParameter("dateOn");
            String dateOff = req.getParameter("dateOff");
            double result = imOutService.QueryScale(name, dateOn, dateOff);
            req.setAttribute("result",result);
            req.getRequestDispatcher("/Port4.jsp").forward(req,resp);
        }

    }




}
