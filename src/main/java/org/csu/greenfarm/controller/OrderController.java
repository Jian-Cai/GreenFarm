package org.csu.greenfarm.controller;

import org.csu.greenfarm.domain.*;
import org.csu.greenfarm.service.CartService;
import org.csu.greenfarm.service.FarmService;
import org.csu.greenfarm.service.OrderService;
import org.csu.greenfarm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    HttpServletRequest request;


    @Autowired
    private CartService cartService;

    @GetMapping("/account/order")
    public String toOrders(Model model){
        request.getSession().setAttribute("status", 3);
        Date date = (Date) request.getSession().getAttribute("time");
        if(request.getParameter("isSet")!=null){
            try{
                PreOrder order = new PreOrder();
                order.setPre_account(request.getParameter("account"));
                order.setPre_time(date);
                order.setPreorderId(request.getSession().getAttribute("orderId").toString());
                order.setRemarks(request.getParameter("remarks"));
                //添加到数据库
                orderService.insertPreOrder(order);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        Account account = (Account)request.getSession().getAttribute("account");
        List<PreOrder> preOrder = orderService.getPreOrderByAccount(account.getAccount());
        List<BuyOrder> buyOrder = orderService.getBuyOrderByAccount(account.getAccount());
        for(int a = 0; a < preOrder.size(); a++){
            String id = preOrder.get(a).getPreorderId();
            preOrder.get(a).setProducts(orderService.getProductByOrderId(id));
        }
        for(int a = 0; a < buyOrder.size(); a++){
            String id = buyOrder.get(a).getBuyorderId();
            buyOrder.get(a).setProducts(orderService.getProductByOrderId(id));
        }
        model.addAttribute("preorder", preOrder);
        model.addAttribute("buyorder", buyOrder);
        request.getSession().setAttribute("preOrder",preOrder);
        return "account/order";
    }

    //跳转支付界面
    @GetMapping("/pay/toPay")
    public String showPay(@RequestParam("preorderId") String preorderId){
        request.getSession().setAttribute("status", 3);
        request.getSession().setAttribute("orderId", preorderId);
        return "pay/toPay";
    }

    //支付成功，定时跳转
    @GetMapping("/pay/paySuccess")
    public String showPaySuccess(@RequestParam("preorderId") String preorderId){
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        List<CartItem> productList = cartService.productList(cart.getCartId());
        for(int a = 0; a < productList.size(); a++){
            try{
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemId(orderService.setOrderId() + orderService.setOrderId());
                orderItem.setOrderId(request.getSession().getAttribute("orderId").toString());
                orderItem.setAmount(productList.get(a).getNum());
                orderItem.setProductId(productList.get(a).getProductId());
                orderService.insertOrderItem(orderItem);
                cartService.removeProduct(cart.getCartId(), productList.get(a).getProductId());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        BuyOrder buyOrder = new BuyOrder();
        Account account = (Account)request.getSession().getAttribute("account");
        buyOrder.setBuy_account(account.getAccount());
        buyOrder.setBuy_date((Date) request.getSession().getAttribute("time"));
        if((Date) request.getSession().getAttribute("time")==null)
            buyOrder.setBuy_date(new Date());
        buyOrder.setBuy_period(11);
        buyOrder.setBuyorderId(request.getSession().getAttribute("orderId").toString());
        orderService.insertBuyOrder(buyOrder);

        request.getSession().removeAttribute("allTotal");
        request.getSession().removeAttribute("items");
        request.getSession().removeAttribute("productList");
        request.getSession().removeAttribute("time");
        orderService.delectOrder(preorderId);
        return "pay/paySuccess";
    }

    //生成订单
    @GetMapping("/order/setOrder")
    public String setOrder(){
        //生成订单号
        Date date = new Date();
        request.getSession().setAttribute("time", date);
        request.getSession().setAttribute("orderId", orderService.setOrderId());
        return "order/setOrder";
    }
}
