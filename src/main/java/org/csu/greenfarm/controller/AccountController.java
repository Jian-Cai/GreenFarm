/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: AccountController.java
 * Date:2019/08/30 21:56:30
 */

package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Account;
import org.csu.greenfarm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    AccountService service;

    @GetMapping("/")
    public String viewLogin() {
        return "index";
    }


    @PostMapping("/tologin")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Account account = service.getAccountByAccount(username) == null ? (service.getAccountByMail(username) == null ? service.getAccountByUsername(username) : service.getAccountByMail(username)) : service.getAccountByAccount(username);
        if (account.getPassword().equals(password))
            return "index";
        else return "account/login";
    }

    @GetMapping("/toregister")
    public String toRegister(){
        return "account/register";
    }
}
