package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/botreply")
    public @ResponseBody String botReply(@RequestBody String text) {
        String greet = "helo";
        String rep;
        if (text.equals(greet)){
            rep = "hi";
        }else rep = "I dont understand you";
        return rep;
    }
}
