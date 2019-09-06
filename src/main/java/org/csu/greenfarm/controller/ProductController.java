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

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/product/productList")
    public String showProductList(@RequestParam("index")int index, Model model){
        request.getSession().setAttribute("status", 2);

        List<Product> p = service.getAllProducts();
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
        request.getSession().setAttribute("status", 2);

        Product product = service.getProductByProductId(productId);
        Farm farm = farmService.getFarmByFarmId(product.getProduct_origin());
        model.addAttribute("origin_farm", farm);
        model.addAttribute("product", product);
        return "product/productItem";
    }

    @GetMapping("/product/productList2")
    public String showProductList(@RequestParam("index")int index, @RequestParam("cate") String cate,  Model model){
        request.getSession().setAttribute("status", 2);

        List<Product> p = service.getProductByProductCate(cate);
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
        model.addAttribute("cate", cate);
        return "product/productList";
    }
}
