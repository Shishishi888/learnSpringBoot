package com.tjulab.helloworld3.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    @GetMapping("/car/{id}/owner/{userName}")
//    @GetMapping("/car/3/owner/ShiYang?age=24&interests=football&interests=game")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("userName") String userName,
                                      @PathVariable Map<String, String> pv,
//                                      @RequestHeader String userAgent,
//                                      @RequestHeader Map<String, String> headers,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("interests")List<String> interests,
                                      @RequestParam Map<String, String> params
//                                      @CookieValue("_ga") String _ga,
//                                      @CookieValue Cookie cookie){
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("userName", userName);
        map.put("pv", pv);
//        map.put("userAgent", userAgent);
//        map.put("headers", headers);
        map.put("age", age);
        map.put("interests", interests);
        map.put("params", params);
//        map.put("_ga", _ga);
//        System.out.println(cookie.getName() + ": " + cookie.getValue());
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){ // post请求才有请求体
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }
}
