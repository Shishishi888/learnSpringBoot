package com.tjulab.adminsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     *
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     *
     * Multipartfile 自动封装上传的文件
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("headerImg") MultipartFile headerImg,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {
        log.info("email={}, username={}, headerImg={}, photos={}", email, username, headerImg.getSize(), photos.length);
        if(!headerImg.isEmpty()){
            // 保存到文件服务器（OSS等）
            String  originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("/Users/shiyang/Desktop/" + originalFilename));
        }
        if(photos.length > 0){
            for(MultipartFile photo : photos){
                if(!photo.isEmpty()){
                    String originalFileName = photo.getOriginalFilename();
                    photo.transferTo(new File("/Users/shiyang/Desktop/" + originalFileName));
                }
            }
        }
        return "index";
    }
}
