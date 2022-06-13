package com.tjulab.helloworld4.controller;

import com.tjulab.helloworld4.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${person.name:ShiYang}")
    private String name;

    @Autowired
    private Person person;

//    @GetMapping("/hello")
//    public String hello(){
//        return "Hello " + name;
//    }

    @GetMapping("/hello")
    public Person hello(){
        return person;
    }

//    @GetMapping("/hello")
//    public String hello(){
//        return person.getClass().toString();
//    }
}
