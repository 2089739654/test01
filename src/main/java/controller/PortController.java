package controller;

import mapper.PortMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Port;
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


@Controller()
@RequestMapping("/Port")
public class PortController{
    @Autowired
    ImOutService imOutService;

    @RequestMapping("/selectNum.do")
    public ModelAndView SelectNum(String name,String dateOn,String dateOff){
        int[] result = imOutService.SelectNum(name, dateOn, dateOff);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("port1");
        mv.addObject("result",result);
        return mv;
    }

    @RequestMapping("/queryGoods.do")
    public ModelAndView QueryGoods(String name, String dateOn, String dateOff, String lading_id){
        Map<String, Integer[]> result = imOutService.QueryGoods(name, dateOn, dateOff, lading_id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("port2");
        mv.addObject("result",result);
        return mv;
    }


    @RequestMapping("/queryScale.do")
    public ModelAndView QueryScale(String name, String dateOn, String dateOff){
        double result = imOutService.QueryScale(name, dateOn, dateOff);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("port3");
        mv.addObject("result",result);
        return mv;
    }

    @RequestMapping("/queryLogistics.do")
    public ModelAndView QueryLogistics(String lading_id){
        Map<String, Integer[]> result = imOutService.QueryLogistics(lading_id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("port4");
        mv.addObject("result",result);
        return mv;
    }

    @RequestMapping("/addPort.do")
    public ModelAndView AddPort(Port port){
        int result = imOutService.insert(port);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("port5");
        mv.addObject("result",result);
        return mv;
    }

    @RequestMapping("/updatePort.do")
    public ModelAndView UpdatePort(Port port){
        int result = imOutService.update(port);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("port6");
        mv.addObject("result",result);
        return mv;
    }

    @RequestMapping("/deletePort.do")
    public ModelAndView DeletePort(Port port){
        int result = imOutService.delete(port);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("port7");
        mv.addObject("result",result);
        return mv;
    }
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String servletPath = req.getServletPath();
//        ImOutService imOutService=new ImOutServiceImp();
//        req.setCharacterEncoding("UTF-8");
//        if("/Port/t1".equals(servletPath)){
//            String name = req.getParameter("name");
//            String dateOn = req.getParameter("dateOn");
//            String dateOff = req.getParameter("dateOff");
//            int[] result = imOutService.SelectNum(name, dateOn, dateOff);
//            req.setAttribute("result",result);
//            req.getRequestDispatcher("/port1.jsp").forward(req,resp);
//        }else if("/Port/t2".equals(servletPath)){
//            String name = req.getParameter("name");
//            String dateOn = req.getParameter("dateOn");
//            String dateOff = req.getParameter("dateOff");
//            String id=req.getParameter("id");
//            Map<String, Integer[]> result = imOutService.QueryGoods(name, dateOn, dateOff, id);
//            req.setAttribute("result",result);
//            req.getRequestDispatcher("/port2.jsp").forward(req,resp);
//        } else if ("/Port/t3".equals(servletPath)) {
//            String id=req.getParameter("id");
//            Map<String, Integer[]> result = imOutService.QueryLogistics(id);
//            req.setAttribute("result",result);
//            req.getRequestDispatcher("/Port3.jsp").forward(req,resp);
//
//        } else if ("/Port/t4".equals(servletPath)) {
//            String name = req.getParameter("name");
//            String dateOn = req.getParameter("dateOn");
//            String dateOff = req.getParameter("dateOff");
//            double result = imOutService.QueryScale(name, dateOn, dateOff);
//            req.setAttribute("result",result);
//            req.getRequestDispatcher("/Port4.jsp").forward(req,resp);
//        }
//
//    }




}
