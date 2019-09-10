package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.*;
import org.csu.greenfarm.service.CommentService;
import org.csu.greenfarm.service.FarmService;
import org.csu.greenfarm.service.OrderService;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FarmService farmService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    CommentService commentService;

    @RequestMapping(value="/setComment", method=RequestMethod.GET)
    private void test1(HttpServletRequest request1, HttpServletResponse response){
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if(request1.getParameter("farmId") == null || request1.getParameter("farmId") == ""){
                ProductCom productCom = new ProductCom();
                productCom.setProductcomId(request1.getParameter("productId") + account.getAccount() + orderService.setOrderId());
                productCom.setProductcom_comment(request1.getParameter("com"));
                productCom.setProductcom_time(Date.from(Instant.now()));
                productCom.setProductcom_account(account.getUsername());
                productCom.setProductcom_product(request1.getParameter("productId"));
                productCom.setProductcom_photo(account.getHead());
                commentService.insertComment(productCom);
            }
            else {
                FarmComment farmComment = new FarmComment();
                farmComment.setFarmcomId(request1.getParameter("farmId") + account.getAccount() + orderService.setOrderId());
                farmComment.setFarmcom_comment(request1.getParameter("com"));
                farmComment.setFarmcom_time(Date.from(Instant.now()));
                farmComment.setFarmcom_username(account.getUsername());
                farmComment.setFarmcom_farmId(request1.getParameter("farmId"));
                farmComment.setFarmcom_photo(account.getHead());
                commentService.insertComment(farmComment);
            }
            response.sendRedirect("account/order");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
