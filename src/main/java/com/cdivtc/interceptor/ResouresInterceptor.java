package com.cdivtc.interceptor;

import com.cdivtc.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResouresInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        // 获取请求的路径
        String uri = request.getRequestURI();
        // 如果用户是已登录状态，放行
        if(user != null){
            return true;
        }
        // 用户登录的相关请求，放行
        if(uri.indexOf("login")>= 0){
            return true;
        }
        // 其他情况都直接跳转到登录界面
        request.setAttribute("msg","您还没有登录，请先登录！");
        request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
        return false;
    }
}
