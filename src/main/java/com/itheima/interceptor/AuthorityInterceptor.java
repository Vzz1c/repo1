package com.itheima.interceptor;

import com.itheima.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userLogin");
        if (user != null) {
            return true;
        }
        request.setAttribute("login_msg","您还未登录,请先登录...");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return false;
    }
}
