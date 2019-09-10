package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.*;
import org.csu.greenfarm.service.AccountService;
import org.csu.greenfarm.service.OrderService;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    AccountService accountService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/adminAccount")
    public String adminAccount(){
        HttpSession session = request.getSession();
        List<Account> accountList = accountService.getAccounts();

        session.setAttribute("status", 3);
        session.setAttribute("accountList",accountList);

        return "account/admin";
    }

    @GetMapping("/adminOrder")
    public String adminOrder(){
        HttpSession session = request.getSession();
        List<PreOrder> allPreOrderList = orderService.getAllPreOrder();
        List<BuyOrder> allBuyOrderList = orderService.getAllBuyOrder();
        session.setAttribute("allPreOrderList",allPreOrderList);
        session.setAttribute("allBuyOrderList",allBuyOrderList);
        session.setAttribute("status", 3);
        return "account/adminOrder";
    }

    @GetMapping("/pushProduct")
    public String pushProduct(){
        HttpSession session = request.getSession();
        List<Product> manageProduct = productService.getAllProducts();
        session.setAttribute("manageProduct",manageProduct);
        session.setAttribute("status", 3);
        return "account/pushProduct";
    }

    @GetMapping("/pullProduct")
    public String pullProduct(){
        HttpSession session = request.getSession();
        List<Product> manageProduct = productService.getAllProducts();
        session.setAttribute("manageProduct",manageProduct);
        session.setAttribute("status", 3);
        return "account/pullProduct";
    }

    @PostMapping("/pushDown")
    public void pushDown(@RequestParam("productId") String productId,@RequestParam("checkId") String checkId, @RequestParam("result") String result){
        productService.putProduct(productId,checkId,result);
        HttpSession session = request.getSession();
        List<Product> manageProduct = productService.getAllProducts();
        session.setAttribute("manageProduct",manageProduct);
    }

    @PostMapping("/pullDown")
    public void pullDown(@RequestParam("productId") String productId){
        System.out.println(productId);
        HttpSession session = request.getSession();
        productService.pullProduct(productId);
        List<Product> manageProduct = productService.getAllProducts();
        session.setAttribute("manageProduct",manageProduct);
    }
}
