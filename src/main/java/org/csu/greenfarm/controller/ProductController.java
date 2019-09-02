/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: ProductController.java
 * Date: 2019/09/02 14:14:02
 */

package org.csu.greenfarm.controller;

/*
处理蔬菜的所有业务逻辑、跳转
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {


    @GetMapping("/product/productList")
    public String showProductList(){
        return "product/productList";
    }
}
