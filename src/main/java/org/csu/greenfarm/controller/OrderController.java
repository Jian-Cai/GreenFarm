package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Account;
import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.PreOrder;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.service.CartService;
import org.csu.greenfarm.service.FarmService;
import org.csu.greenfarm.service.OrderService;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private FarmService farmService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private CartService cartService;


    @GetMapping("/account/order")
    public String toOrders(Model model){
        request.getSession().setAttribute("status", 3);

        Account account = (Account)request.getSession().getAttribute("account");
        List<PreOrder> preOrder = orderService.getPreOrderByAccount(account.getAccount());
        model.addAttribute("preorder", preOrder);
        return "account/order";
    }

    //跳转支付界面
    @GetMapping("/pay/toPay")
    public String showPay(@RequestParam("preorderId") String preorderId){
        request.getSession().setAttribute("status", 3);

        orderService.delectOrder(preorderId);
        return "pay/toPay";
    }

    //支付成功，定时跳转
    @GetMapping("/pay/paySuccess")
    public String showPaySuccess(){
        return "pay/paySuccess";
    }
}
