package org.csu.greenfarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @GetMapping("/")
    public String viewLogin() {
        return "account/login";
    }


    @PostMapping("/tologin")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        if (username.equals("admin") && password.equals("123456"))
            return "index";
        else return "account/login";
    }

    @GetMapping("/toregister")
    public String toRegister(){
        return "account/register";
    }
}
