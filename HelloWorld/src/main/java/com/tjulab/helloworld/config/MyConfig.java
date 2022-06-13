package com.tjulab.helloworld.config;

import com.tjulab.helloworld.bean.Car;
import com.tjulab.helloworld.bean.Pet;
import com.tjulab.helloworld.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 配置类里使用@Bean向容器注册组件，注册的组件默认是单实例的
 * 配置类本身也是组件
 * proxyBeanMethods默认为true，代理bean的方法
 *  Full模式：proxyBeanMethods = true，允许组件依赖
 *  Lite模式：proxyBeanMethods = false，代码中没有组件依赖时最好将proxyBeanMethods设为false，SpringBoot启动快
 */
@Configuration(proxyBeanMethods = true)
// @Configuration(proxyBeanMethods = false)
// @Configuration // 告知这是一个配置类
// @ConditionalOnBean(name = "pet01") // 只有当容器中有组件pet01时，才向容器中注册以下所有组件
@ConditionalOnMissingBean(name = "pet01") // 只有当容器中没有组件pet01时，才向容器中注册以下所有组件
@ImportResource("classpath:beans.xml") // 导入以前的Spring配置文件，以免麻烦的迁移工作
@EnableConfigurationProperties(Car.class) // 开启Car的属性配置绑定功能，并将Car组件自动注入到容器中
public class MyConfig {
    /**
     * 向容器中添加组件
     * 以方法名作为组件的id；以返回类型作为组件的类型；返回值就是组件在容器中的实例
     * proxyBeanMethods = true，代理对象，外部无论调用多少次配置类里的组件注册方法，获得的都是之前注册到容器中的单实例对象
     * proxyBeanMethods = false，外部每次调用配置类里的组件注册方法，都会获得新的对象
     */
    // @ConditionalOnBean(name = "pet01") // 只有当容器中有组件pet01时，才向容器中注册组件user01
    @Bean
    public User user01(){
        User ShiYang = new User("ShiYang", 18);
        ShiYang.setPet(pet01());
        return ShiYang;
    }

    @Bean("tom01")
    public Pet pet01(){
        return new Pet("tom");
    }
}
