package com.tjulab.adminsystem.controller;

import com.tjulab.adminsystem.bean.NbData;
import com.tjulab.adminsystem.bean.User;
import com.tjulab.adminsystem.service.NbDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NbDataService nbDataService;

//    @Autowired
//    StringRedisTemplate redisTemplate;

    @ResponseBody
    @GetMapping("/nbdata")
    public NbData getById(@RequestParam("dataId") String dataId){
        return nbDataService.getNbDataById(dataId);
    }

    @GetMapping(value={"/", "/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassWord())){
            session.setAttribute("loginUser", user);
            return "redirect:/index.html";
        }
        else{
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
        // return "index";

        // return "redirect:/index.html"; // 登录成功，重定向到index页面，防止表单重复提交
    }

    @GetMapping("/index.html")
    public String indexPage(HttpSession session, Model model){
        log.info("当前方法是：{}", "indexPage");

//        // 拦截器
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "index";
//        }
//        else {
//            model.addAttribute("msg", "请重新登录");
//            return "login";
//        }

//        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
//        String s = opsForValue.get("/index.html");
//        model.addAttribute("mainCount", s);
        return "index";
    }
}
