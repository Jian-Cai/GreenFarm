package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Account;
import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.PreOrder;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.service.FarmService;
import org.csu.greenfarm.service.OrderService;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


    @GetMapping("/account/order")
    public String toOrders(Model model){
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

        Account account = (Account)request.getSession().getAttribute("account");
        List<PreOrder> preOrder = orderService.getPreOrderByAccount(account.getAccount());
        /*List<Product> preorderProduct = new ArrayList<>();
        for(int a = 0; a < preOrder.size(); a++){
            preorderProduct.add(preOrder.get(a).);
        }

        System.out.println(preorderProduct.get(0).getProductId());

        model.addAttribute("preorderProduct", preorderProduct);
        */
        model.addAttribute("preorder", preOrder);
        return "account/order";
    }
}
