package com.tjulab.adminsystem.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 * 登录检查
 *
 * 1. 规定好拦截器要拦截哪些请求
 * 2. 把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 方法的执行顺序：preHandle --> 请求方法 --> postHandle --> afterCompletion
     *
     * 拦截器原理
     * 根据当前的请求，找到HandlerExecutionChain（可以处理请求的handler以及handler的所有拦截器）
     * 先顺序执行所有拦截器的preHandle方法
     *      如果当前拦截器的preHandler返回true，继续执行下一个拦截器的preHandle方法；
     *      如果当前拦截器的preHandler返回false，则逆序执行所有已经执行了的拦截器的afterCompletion。任何一个拦截器返回false，都会导致跳出而不能执行目标方法，只有当所有的拦截器都返回true时，才执行目标方法
     * 再逆序执行所有拦截器的postHandle方法
     *
     * 前面任何步骤发生异常都会触发afterCompletion
     *
     * 页面成功渲染以后，也会逆序触发afterCompletion
     */

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是{}", requestURI);

        /**
         * 在preHandle写登录检查逻辑
         */
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null)
            return true;

//         session.setAttribute("msg", "请先登录");
//         response.sendRedirect("/"); // 重新回到登录页
        request.setAttribute("msg", "请先登录");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
        //  return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 目标方法执行之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}", modelAndView);
    }

    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}", ex);
    }
}
