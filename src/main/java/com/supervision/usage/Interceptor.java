package com.supervision.usage;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor {


    // 有效的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        System.out.println("----------------------------preHandle----------------------------");

        // 获取请求的RUi:去除http:localhost:8080这部分剩下的
        String uri = request.getRequestURI();

        // UTL:除了login.jsp和password。jsp是可以公开访问的，其他的URL都进行拦截控制
        if (uri.contains("/login") || uri.contains("/password")) {
            return true;
        }

        // 获取session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("USER_SESSION_name");

        // 判断session中是否有用户数据，如果有，则返回true，继续向下执行
        if (username.equals("")) {
            //不符合条件的给出提示信息，并转发到登录页面
            request.setAttribute("msg", "Please Login !");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}