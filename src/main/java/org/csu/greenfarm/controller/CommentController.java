package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.Account;
import org.csu.greenfarm.domain.Farm;
import org.csu.greenfarm.domain.FarmComment;
import org.csu.greenfarm.service.CommentService;
import org.csu.greenfarm.service.FarmService;
import org.csu.greenfarm.service.OrderService;
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
    CommentService commentService;

    @RequestMapping(value="/setComment", method=RequestMethod.GET)
    private void test1(HttpServletRequest request1, HttpServletResponse response){
        try {
            FarmComment farmComment = new FarmComment();
            Farm farm = farmService.getFarmByFarmId(request1.getParameter("farmId"));
            Account account = (Account) request.getSession().getAttribute("account");
            farmComment.setFarmcomId(request1.getParameter("farmId") + account.getAccount() + orderService.setOrderId());
            farmComment.setFarmcom_comment(request1.getParameter("com"));
            farmComment.setFarmcom_time(Date.from(Instant.now()));
            farmComment.setFarmcom_username(account.getUsername());
            farmComment.setFarmcom_farmId(request1.getParameter("farmId"));
            farmComment.setFarmcom_photo(farm.getFarm_photo());
            commentService.insertComment(farmComment);

            response.sendRedirect("account/order");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
