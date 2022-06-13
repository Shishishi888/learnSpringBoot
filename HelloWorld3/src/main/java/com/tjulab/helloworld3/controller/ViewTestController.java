package com.tjulab.helloworld3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
    @GetMapping("/attju")
    public String attju(Model model){
        // model中的数据会被放在请求域中 request.setAttribute("key", value);
        model.addAttribute("msg", "hello tju");
        model.addAttribute("link", "https://www.baidu.com/");
        return "success";
    }
}
