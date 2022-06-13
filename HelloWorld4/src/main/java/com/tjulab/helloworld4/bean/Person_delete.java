package com.tjulab.helloworld4.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("person")
public class Person_delete {
    private String name;
    private Integer age;
}
