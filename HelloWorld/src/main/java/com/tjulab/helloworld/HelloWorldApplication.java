package com.tjulab.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 * @SpringBootApplication 告知这是一个SpringBoot应用
 */

// @SpringBootApplication // 默认扫描主程序所在的包
// @SpringBootApplication(scanBasePackages="com.tjulab") // 改变包的扫描路径

@SpringBootConfiguration
@EnableAutoConfiguration
// @ComponentScan("com.tjulab")
@ComponentScan("com.tjulab.helloworld")
public class HelloWorldApplication {
    public static void main(String[] args){
        // SpringApplication.run(HelloWorldApplication.class, args);

        // 1. 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(HelloWorldApplication.class, args);

        // 2. 查看容器内的组件
        String[] names = run.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

        // 3. 从容器中获取组件
//        Pet tom001 = run.getBean("tom01", Pet.class); // 注册的组件默认是单实例的
//        Pet tom002 = run.getBean("tom01", Pet.class); // 注册的组件默认是单实例的
//
//        System.out.println(tom001 == tom002);
//
//        MyConfig myConfig = run.getBean(MyConfig.class); // 配置类本身也是一个组件
//        System.out.println(myConfig);
//
//        /**
//         * proxyBeanMethods = true，代理对象调用方法
//         * SpringBoot总会检查组件是否在容器中，在则直接获取，不在则新创（保持组件单实例）
//         */
//        User user001 = myConfig.user01(); // 外部无论调用多少次配置类里的组件注册方法，获得的都是之前注册到容器中的单实例对象
//        User user002 = myConfig.user01(); // 外部无论调用多少次配置类里的组件注册方法，获得的都是之前注册到容器中的单实例对象
//        System.out.println(user001 == user002);
//
//
//        /**
//         * 组件依赖问题
//         * proxyBeanMethods = true，允许组件依赖，容器中的组件pet01就是user01中依赖的pet
//         * proxyBeanMethods = false，不允许组件依赖
//         */
//        User user01 = run.getBean("user01", User.class);
//        Pet pet01 = run.getBean("tom01", Pet.class);
//
//        System.out.println(pet01 == user01.getPet());
//
//        String[] beanNamesForUser = run.getBeanNamesForType(User.class);
//        System.out.println();
//        for(String s: beanNamesForUser){
//            System.out.println(s);
//        }
//
//        DBHelper dbHelper = run.getBean(DBHelper.class);
//        System.out.println(dbHelper);

        boolean user01 = run.containsBean("user01");
        System.out.println(user01);

//        boolean pet01 = run.containsBean("pet01");
//        System.out.println(pet01);

        boolean pet01 = run.containsBean("tom01");
        System.out.println(pet01);


        boolean user0001 = run.containsBean("user0001");
        System.out.println(user0001);

        boolean pet0001 = run.containsBean("pet0001");
        System.out.println(pet0001);


        String[] beanNamesForCache = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println(beanNamesForCache.length);

        String[] beanNamesForWeb = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println(beanNamesForWeb.length);

    }
}
