package com.tjulab.adminsystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjulab.adminsystem.bean.User;
import com.tjulab.adminsystem.exception.UserTooManyException;
import com.tjulab.adminsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    /**
     * 400: Bad Request 一般都是浏览器传递的参数发生错误
     * @param a
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int i = 10 / 0; // 数学运算异常
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1")Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn", pn); // 重定向
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1")Integer pn, Model model){
//    public String dynamic_table(Model model){
//        // 遍历表格的内容
//        List<User> users = Arrays.asList(new User("ShiYang", "123456"),
//                new User("Shishi", "123456"),
//                new User("Shishishi", "123456")
//                );
//        model.addAttribute("users", users);
//
//        // response.sendError
//
//        if(users.size() >= 3){ // 设置异常
//            throw new UserTooManyException();
//        }

        // 从数据库中查出user表中的用户
        List<User> list = userService.list();
//        model.addAttribute("users", list);

        // 分页查询
        Page<User> userPage = new Page<>(pn, 2); // pn是当前查询的页码，size是每页显示的条数

        // 分页查询的结果
        Page<User> page = userService.page(userPage, null);

        model.addAttribute("page", page);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
