package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter({"/index.jsp","/Port/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        String servletPath = httpServletRequest.getServletPath();
        System.out.println(servletPath);
        HttpSession httpSession= httpServletRequest.getSession(false);
        if(httpSession!=null&&httpSession.getAttribute("username")!=null){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
        else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/welcome.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
