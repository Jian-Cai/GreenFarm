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
    public String showProductList(@RequestParam("index")int index, Model model){
        //header、footer信息
        List<Farm> f = farmService.getAllFarm();
        List<Product> p = service.getAllProducts();
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
        model.addAttribute("main_status", 2); //状态码

        int num = (int) Math.ceil((double)p.size()/3);
        List<Product> indexList = new ArrayList<>();
        //每一页展示3个
        for(int a = index*3; a < (index+1)*3; a++){
            if(a < p.size()){
                indexList.add(p.get(a));
            }
            else break;
        }
        model.addAttribute("index", index);
        model.addAttribute("pageNum",num-1); //num从0开始
        model.addAttribute("products1", indexList); //model内添加ProductList
        return "product/productList";
    }

    @GetMapping("/product/productItem")
    public String showProductItem(@RequestParam("productId") String productId, Model model){
        //header、footer信息
        List<Farm> f = farmService.getAllFarm();
        List<Product> p = service.getAllProducts();
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
        model.addAttribute("main_status", 2); //状态码

        Product product = service.getProductByProductId(productId);
        Farm farm = farmService.getFarmByFarmId(product.getProduct_origin());
        model.addAttribute("origin_farm", farm);
        model.addAttribute("product", product);
        return "product/productItem";
    }
}
