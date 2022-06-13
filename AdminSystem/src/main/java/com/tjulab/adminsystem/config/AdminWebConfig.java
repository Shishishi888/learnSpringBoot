package com.tjulab.adminsystem.config;

import com.tjulab.adminsystem.interceptor.LoginInterceptor;
import com.tjulab.adminsystem.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 实现拦截器
 * 1. 编写一个拦截器实现HandlerInterceptor接口
 * 2. 将拦截器注册到容器中（即实现WebMvcConfigurer的addInterceptors方法）
 * 3. 指定拦截规则
 */

/**
 * @EnableWebMvc
 * @EnableWebMvc + WebMvcConfigurer + @Bean
 * 全面接管SpringMVC，WebMvcAutoConfiguration将失效，因此原来的一些自动配置（静态资源、试图解析器、欢迎页等）将全部失效，需要重新手动配置
 */
// @EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     * Filter和Interceptor
     * 几乎拥有相同的功能，都是拦截器
     *
     * Filter
     * Servlet定义的原生组件，脱离Spring应用也能使用
     *
     * Interceptor
     * Spring定义的接口，只能在Spring应用中使用，可以使用Spring的自动装配等功能
     */

//    @Autowired
//    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // 添加拦截路径。"/**"的意思是默认拦截所有的请求，包括静态资源
//                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**"); // 添加放行路径
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**", "/a/**"); // 添加放行路径

//        registry.addInterceptor(redisUrlCountInterceptor) // 因为RedisUrlCountInterceptor类Autowired了StringRedisTemplate组件，而RedisUrlCountInterceptor只有以组件的形式注册到容器中，Spring才会解析内部的注解，
//                                                          // 因此在AdminWebConfig类的addInterceptor方法中不能用new，而是以获取组件的形式获得RedisUrlCountInterceptor
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**", "/a/**");

    }

    /**
     * 定制化组件
     * 修改SpringMVC底层的组件
     */
//    @Bean
//    public WebMvcRegistrations webMvcRegistrations(){
//        return new WebMvcRegistrations() {
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping(){ // 重新定义handlerMapping的行为
//                return null;
//            }
//        };
//    }

    /**
     * 定制化组件
     * @EnableWebMvc + WebMvcConfigurer + @Bean
     */
    // 重新定义静态资源行为
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/a/**") // 访问"/a/**"的所有请求，都去"classpath:/static/"下进行匹配
//                .addResourceLocations("classpath:/static/");
//    }
}
