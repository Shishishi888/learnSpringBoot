package com.tjulab.helloworld3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "success");
        request.setAttribute("code", 200);
        return "forward:/success"; // 转发到 /success 请求
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        /**
         * Map、Model、HttpServletRequest都可以向request域中添加数据
         */
        map.put("hello", "word");
        model.addAttribute("hello1", "world1");
        request.setAttribute("message", "HelloWorld");

        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:success";

    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg", required = false) String msg1,
                          @RequestAttribute(value = "code", required = false) String code,
                          HttpServletRequest request){
        Object msg2 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();

        Object hello = request.getAttribute("hello");
        Object hello1 = request.getAttribute("hello1");
        Object message = request.getAttribute("message");

        map.put("annotation_msg", msg1);
        map.put("reqMethod_msg", msg2);
        map.put("hello", hello);
        map.put("hello1", hello1);
        map.put("message", message);

        return map;
    }

    /**
     * 矩阵变量
     *
     * 页面开发，cookie禁用，session里的内容如何处理
     * seesion.set(a, b) ---> jsessionid ---> cookie ---> 发请求携带
     * cookie禁用，jsessionid无法携带，服务器无法找到session对象，也就无法访问session中的kv值
     * url重写：/abc;jsessionid = xxxx
     * 可以使用矩阵变量传递原来cookie的值
     *
     *
     * 语法 /cars/sell;low=34;brand=byd,audi,yd
     * SpringBoot 默认禁用矩阵变量的功能
     * 手动开启
     */
    @ResponseBody
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                           @MatrixVariable("brand") List<String> brand,
                            @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    // /boss/1;age=10/2;age=10
    @ResponseBody
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge){
        Map<String, Object> map  = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
