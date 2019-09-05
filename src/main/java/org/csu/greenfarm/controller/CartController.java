package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import org.csu.greenfarm.service.ProductService;
import org.csu.greenfarm.service.FarmService;
@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    FarmService farmService;

    @GetMapping("/toCart")
    public String viewCart(Model model){
        List<Product> p = productService.getAllProducts();
        List<Farm> f = farmService.getAllFarm();
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

        return "product/cart";
    }
}
