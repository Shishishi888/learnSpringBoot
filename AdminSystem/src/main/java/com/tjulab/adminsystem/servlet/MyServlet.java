package com.tjulab.adminsystem.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册Servlet三大原生组件：Servlet、Filter、Listener
 * 第一种方式
 *
 * 直接响应，没有经过SpringBoot的拦截器
 */
// @WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("123");
    }
}
