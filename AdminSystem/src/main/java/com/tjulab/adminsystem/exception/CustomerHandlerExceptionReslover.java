package com.tjulab.adminsystem.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义异常解析器
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE) // 给予该异常解析器最高的优先级，任何异常都会优先使用该异常解析器解析。数字越小，优先级越高
@Component
public class CustomerHandlerExceptionReslover implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.sendError(511, "自定义异常");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
