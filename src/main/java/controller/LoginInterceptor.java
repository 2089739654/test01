package controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null){
            return true;
        }else {
            request.getRequestDispatcher("/welcome.jsp").forward(request,response);
            return false;
        }
    }
}

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
//        String servletPath = httpServletRequest.getServletPath();
//        System.out.println(servletPath);
//        HttpSession httpSession= httpServletRequest.getSession(false);
//        if(httpSession!=null&&httpSession.getAttribute("username")!=null){
//            filterChain.doFilter(httpServletRequest,httpServletResponse);
//        }
//        else {
//            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/welcome.jsp");
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }