/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: IndexController.java
 * Date: 2019/09/01 09:29:01
 */

package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.service.FarmService;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
/*
展示主页面，基本页面的跳转逻辑
 */

    @Autowired
    private FarmService farmService;

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpServletRequest request;


    @GetMapping("/") //展示主页面 index.html
    public String viewLogin() {
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
        request.getSession().setAttribute("main_farm", farms);
        request.getSession().setAttribute("main_product", products);
        request.getSession().setAttribute("status", 0);
        return "index";
    }
    @GetMapping("/app/app") //展示主页面 index.html
    public String viewAPP() {
        return "/app/app";
    }
}
