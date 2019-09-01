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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
跳转至登录界面&个人中心界面
 */
@Controller
public class AccountController {

    @Autowired
    AccountService service;

    @Autowired
    HttpServletRequest request;

    //跳转至个人中心界面
    @GetMapping("/account/account")
    public String showaccount(){
        HttpSession session = request.getSession();
        //如果session中的account为空则去登录
        return session.getAttribute("account") == null ? "login/login" : "account/account";
    }

    //跳转至登录界面
    @PostMapping("/tologin")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        //通过邮箱、账户、昵称登录
        Account account = service.getAccountByAccount(username) == null ? (service.getAccountByMail(username) == null ? service.getAccountByUsername(username) : service.getAccountByMail(username)) : service.getAccountByAccount(username);
        if (account.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            return "account/account";
        }
        else{

            return "login/login";
        }
    }

    @GetMapping("/toregister")
    public String toRegister(){
        return "login/register";
    }
}
