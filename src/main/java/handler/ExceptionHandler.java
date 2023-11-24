package handler;

import exception.ClientException;
import exception.FailSignInException;
import exception.NoUserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NoUserException.class)
    public ModelAndView doNoUserException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","登录失败");
        mv.addObject("ex",ex);
        mv.setViewName("Error1");
        return mv;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = FailSignInException.class)
    public ModelAndView doFailSignInException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg",ex.getMessage());
        mv.addObject("ex",ex);
        mv.setViewName("Error2");
        return mv;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ClientException.class)
    public ModelAndView doClientException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","添加失败");
        mv.addObject("ex",ex);
        mv.setViewName("Error3");
        return mv;
    }


    @org.springframework.web.bind.annotation.ExceptionHandler
    public ModelAndView doOtherException(Exception exception){
        ModelAndView mv=new ModelAndView();
        mv.addObject("exception",exception);
        mv.setViewName("Error");
        return mv;
    }




}
