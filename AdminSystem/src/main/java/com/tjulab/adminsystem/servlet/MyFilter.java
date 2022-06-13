package com.tjulab.adminsystem.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 注册Servlet三大原生组件：Servlet、Filter、Listener
 * 第一种方式
 */
@Slf4j
// @WebFilter(urlPatterns = {"/css/*", "/images/*"}) // 设置拦截路径
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter运行");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
