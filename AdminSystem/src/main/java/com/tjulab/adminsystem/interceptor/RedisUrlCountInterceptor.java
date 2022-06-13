package com.tjulab.adminsystem.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记录URI的访问次数
 *
 * 因为只有以组件的形式注册到容器中，Spring才会解析内部的注解，因此要加上@Component
 */
@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        redisTemplate.opsForValue().increment(uri); // 每访问一次当前的uri，计数加1
        return true;
    }
}
