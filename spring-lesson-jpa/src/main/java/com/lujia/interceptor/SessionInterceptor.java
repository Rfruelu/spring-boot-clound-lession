package com.lujia.interceptor;

import com.lujia.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :lujia
 * @date :2018/11/20  11:17
 */
public class SessionInterceptor implements HandlerInterceptor {

    /**
     * 请求之前处理
     *
     * @param request
     * @param response
     * @param handler
     * @return true 不做拦截，false拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().equals("/login") || request.getRequestURI().equals("/user/login")
                || request.getRequestURI().equals("/error")) {
            //不做拦截
            return true;
        }
        User user = (User) request.getSession().getAttribute("session-user");
        if (user == null) {
            //未登录，需要跳转到登录页面，并拦截
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

    /**
     * 请求之后处理
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * HandlerInterceptorAdapter的preHandle方法的返回值为true时，并且DispatcherServlet渲染了对应的视图之后才执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
