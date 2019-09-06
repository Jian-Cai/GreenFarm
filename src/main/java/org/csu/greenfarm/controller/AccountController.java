/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: AccountController.java
 * Date:2019/08/30 21:56:30
 */

package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Account;
import org.csu.greenfarm.domain.Cart;
import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.service.AccountService;
import org.csu.greenfarm.service.CartService;
import org.csu.greenfarm.service.FarmService;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private FarmService farmService;

    @Autowired
    private ProductService productService;

    @Autowired
    AccountService service;

    @Autowired
    CartService cartService;

    @Autowired
    HttpServletRequest request;

    //跳转至个人中心界面
    @GetMapping("/account/account")
    public String showaccount(){
        HttpSession session = request.getSession();
        //header、footer信息
        session.setAttribute("status", 3);
        return session.getAttribute("account") == null ? "login/login" : "account/account";
    }


    //跳转至登录界面
    @PostMapping("/tologin")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

        request.getSession().setAttribute("status", 3);
        //通过邮箱、账户、昵称登录
        Account account = service.getAccount(username);
        if (account.getPassword().equals(password)){
            Cart cart = cartService.initCart(account.getAccount());
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            session.setAttribute("cart", cart);
            return "account/account";
        }
        else{

            return "login/login";
        }

    }

    //用户登录
    @GetMapping("/toregister")
    public String toRegister(){
        request.getSession().setAttribute("status", 3);
        return "login/register";
    }

    //跳转至用户协议
    @GetMapping("/touserAg")
    public String toAg(){
        request.getSession().setAttribute("status", 3);
        return "login/userAg";
    }

    @GetMapping("signon")
    public String signOn(Account account){
        service.signOn(account);
        return "account/account";
    }

    @GetMapping("toMyAccount")
    public String toMyAccount(){
        request.getSession().setAttribute("status", 3);
        return "account/account";
    }

    @GetMapping("/toMyMessage")
    public String toMyMessage(){
        request.getSession().setAttribute("status", 3);
        return "account/messages";
    }

    @GetMapping("/tologout")
    public String toLogout(){
        request.getSession().setAttribute("status", 0);

        request.getSession().removeAttribute("account");
        return "index";
    }
}
