/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: FarmController.java
 * Date: 2019/09/01 11:17:01
 */

package org.csu.greenfarm.controller;

import org.apache.catalina.LifecycleState;
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
农场页面以及农场业务逻辑展示跳转
 */

@Controller
public class FarmController {

    @Autowired
    FarmService service;

    @Autowired
    private ProductService productService;

    //return farmList
    @GetMapping("/farm/farmList")
    public String showFarmList(Model model){
        //header、footer信息
        List<Farm> f = service.getAllFarm();
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
        model.addAttribute("main_status", 1); //状态码



        List<Farm> farms1 = new ArrayList<>();
        List<Farm> farms2 = new ArrayList<>();


        //一页仅显示6个项目
        for(int a = 0; a < 3; a++){
            if(a < f.size()){
                if(f.get(a).getFarm_item().length() >= 8){
                    String s = f.get(a).getFarm_item();
                    f.get(a).setFarm_item_short(s.substring(0,8)+"...");
                }
                farms1.add(f.get(a));
            }
        }
        for(int a = 3; a < 6; a++){
            if(a < f.size()){
                if(f.get(a).getFarm_item().length() >= 8){
                    String s = f.get(a).getFarm_item();
                    f.get(a).setFarm_item_short(s.substring(0,8)+"...");
                }
                farms2.add(f.get(a));
            }
        }
        model.addAttribute("farms1", farms1); //model内添加farmList
        model.addAttribute("farms2", farms2);
        return "farm/farmList";
    }

    //return farm item by farmId
    @GetMapping("/farm/farmItem")
    public String showFarmItem(@RequestParam("farmId") String farmId, Model model){
        //header、footer信息
        List<Farm> f = service.getAllFarm();
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
        model.addAttribute("main_status", 1); //状态码

        Farm farm = service.getFarmByFarmId(farmId);
        model.addAttribute("farm", farm);
        model.addAttribute("farm_product", productService.getProductByProductOrigin(farmId));
        return "farm/farmItem";
    }

}
