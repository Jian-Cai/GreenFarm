/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: ProductController.java
 * Date: 2019/09/02 14:14:02
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/*
处理蔬菜的所有业务逻辑、跳转
 */


@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private FarmService farmService;

    @GetMapping("/product/productList")
    public String showProductList(Model model){
        List<Product> products1 = new ArrayList<>();
        List<Product> products2 = new ArrayList<>();
        List<Product> p = service.getAllProducts();
        for(int a = 0; a < 3; a++){
            if(a < p.size()){
                products1.add(p.get(a));
            }
        }
        for(int a = 3; a < 6; a++){
            if(a < p.size()){
                products2.add(p.get(a));
            }
        }
        model.addAttribute("products1", products1); //model内添加farmList
        model.addAttribute("products2", products2);
        return "product/productList";
    }

    @GetMapping("/product/productItem")
    public String showProductItem(@RequestParam("productId") String productId, Model model){
        Product product = service.getProductByProductId(productId);
        Farm farm = farmService.getFarmByFarmId(product.getProduct_origin());
        model.addAttribute("origin_farm",farm );
        model.addAttribute("product", product);
        return "product/productItem";
    }
}
