package com.tjulab.helloworld.controller;

import ch.qos.logback.core.db.DBHelper;
import com.tjulab.helloworld.bean.Car;
import com.tjulab.helloworld.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // 日志

/**
 * Import()
 * 向容器中注入指定的组件
 * 组件的名字默认为全类名
 */
@Import({User.class, DBHelper.class})

//@ResponseBody
//@Controller
@RestController // 相当于@Controller + @ResponseBody，告知浏览器handle01返回的是字符串而非url
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(){

        // return "Hello World!";

        log.info("请求...");
        return "Hello World!" + " " + "你好，世界！";
    }
}
