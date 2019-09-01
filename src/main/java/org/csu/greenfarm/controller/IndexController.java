/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: IndexController.java
 * Date: 2019/09/01 09:29:01
 */

package org.csu.greenfarm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
/*
展示主页面，基本页面的跳转逻辑
 */

    @GetMapping("/") //展示主页面 index.html
    public String viewLogin() {
        return "index";
    }
}
