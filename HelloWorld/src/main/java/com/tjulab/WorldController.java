package com.tjulab;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {
    @RequestMapping("/w")
    public String myWorld(){
        return "myWorld";
    }
}
