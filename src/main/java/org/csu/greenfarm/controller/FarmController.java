/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: FarmController.java
 * Date: 2019/09/01 11:17:01
 */

package org.csu.greenfarm.controller;

import org.csu.greenfarm.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/*
农场页面以及农场业务逻辑展示跳转
 */

@Controller
public class FarmController {

    @Autowired
    FarmService service;

    //return farmList
    @GetMapping("/farm/farmList")
    public String showFarmList(Model model){
        model.addAttribute("farms", service.getAllFarm()); //model内添加farmList
        return "farm/farmList";
    }

    //return farm item by farmId
    @GetMapping("/farm/farmItem")
    public String showFarmItem(@RequestParam("farmId") String farmId){
        return "farm/farmItem";
    }

}
