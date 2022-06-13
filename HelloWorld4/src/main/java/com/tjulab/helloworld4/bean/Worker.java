package com.tjulab.helloworld4.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test") // 指定环境配置文件
@Component
@ConfigurationProperties("person")
@Data
public class Worker implements Person{
    private String name;
    private Integer age;
}
