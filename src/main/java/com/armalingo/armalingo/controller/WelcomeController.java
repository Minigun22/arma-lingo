package com.armalingo.armalingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/select-language")
    public String selectLanguagePage(){
        return "welcome/select-language";
    }

    @GetMapping("/select-role")
    public String selectRolePage(){ return  "welcome/select-role";}

}