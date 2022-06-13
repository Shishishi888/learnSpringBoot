package com.tjulab.helloworld4.config;

import com.tjulab.helloworld4.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyConfig {
    @Profile("prod")  // 指定环境配置文件
    @Bean
    public Color red(){
        return new Color();
    }

    @Profile("test")  // 指定环境配置文件
    @Bean
    public Color green(){
        return new Color();
    }
}
