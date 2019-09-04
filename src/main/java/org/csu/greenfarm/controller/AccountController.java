/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: AccountController.java
 * Date:2019/08/30 21:56:30
 */

package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Account;
import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.service.AccountService;
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
import java.util.ArrayList;
import java.util.List;

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
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        //header、footer信息
        List<Farm> f = farmService.getAllFarm();
        List<Product> p = productService.getAllProducts();
        List<Farm> farms = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        for (int a = 0; a < 6; a++){
            if(a < f.size()){
                farms.add(f.get(a));
            }
            if(a < p.size()){
                products.add(p.get(a));
            }
        }
        model.addAttribute("main_farm", farms);
        model.addAttribute("main_product", products);
        model.addAttribute("main_status", 3); //状态码


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

    //用户登录
    @GetMapping("/toregister")
    public String toRegister(){
        return "login/register";
    }

    //跳转至用户协议
    @GetMapping("/touserAg")
    public String toAg(){
        return "login/userAg";
    }

    @GetMapping("signon")
    public String signOn(Account account){
        service.signOn(account);
        return "account/account";
    }
}
