package com.armalingo.armalingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/welcome/select-language")
    public String selectLanguagePage(){
        return "welcome/select-language";
    }



}
