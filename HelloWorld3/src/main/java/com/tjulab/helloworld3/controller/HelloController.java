package com.tjulab.helloworld3.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping("/cat.jpg")
    public String hello(@RequestParam("username") String name){
//    public String hello(HttpSession session){
//    public String hello(Model model){
//    public String hello(Person person){
//    public String hello(){
        return "123";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET ShiYang";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String postUser(){
        return "POST ShiYang";
    }

    // @RequestMapping(value = "/user", method = RequestMethod.PUT) // PUT方法经过过滤器包装
    @PutMapping("/user")
    public String putUser(){
        return "PUT ShiYang";
    }

    @DeleteMapping("/user")
    // @RequestMapping(value = "/user", method = RequestMethod.DELETE) // DELETE方法经过过滤器包装
    public String deleteUser(){
        return "DELETE ShiYang";
    }
}
