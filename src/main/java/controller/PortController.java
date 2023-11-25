package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Port;
import service.ImOutService;

import java.util.Map;


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

}
