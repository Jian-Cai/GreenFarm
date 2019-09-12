/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: AccountController.java
 * Date:2019/08/30 21:56:30
 */

package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.*;
import org.csu.greenfarm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    CartService cartService;

    @Autowired
    OrderService orderService;

    @Autowired
    HttpServletRequest request;

    //跳转至个人中心界面
    @GetMapping("/account/account")
    public String showaccount(){
        HttpSession session = request.getSession();
        //header、footer信息
        session.setAttribute("status", 3);

        Account account  = (Account)session.getAttribute("account");
        return account.getAccount().equals("666") ? "account/admin" : "account/account";
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
            if(account.getUsername().equals("admin")) {
                List<Account> accountList = service.getAccounts();
                session.setAttribute("accountList",accountList);
                return "account/admin";
            }
            else return "account/account";

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
    public String signOn(){
        if(request.getParameter("checkbox1") != null){
            try {
                Account account1 = new Account();
                account1.setAccount(request.getParameter("account"));
                account1.setMail(request.getParameter("mail"));
                account1.setUsername(request.getParameter("username"));
                account1.setPassword(request.getParameter("password"));
                account1.setRecadd(request.getParameter("recadd"));
                request.getSession().setAttribute("account", account1);
                service.signOn(account1);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
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

    @ResponseBody
    @PostMapping("/login")
    public boolean inPageLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        Account account = service.getAccount(username);
        if(account.getPassword().equals(password)){
            Cart cart = cartService.initCart(account.getAccount());
            double allTotal = cartService.getAllTotal(cart.getCartId());
            HttpSession session = request.getSession();
            session.setAttribute("allTotal", allTotal);
            session.setAttribute("account", account);
            session.setAttribute("cart", cart);
            return true;
        }
        else return false;
    }


    //上架

    //下架

}
