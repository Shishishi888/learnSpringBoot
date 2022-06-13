package com.tjulab.helloworld2.controller;

import com.tjulab.helloworld2.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld2Controller {
    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person(){
        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }
}
