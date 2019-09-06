package org.csu.greenfarm.service;

import org.csu.greenfarm.domain.BuyOrder;
import org.csu.greenfarm.domain.OrderItem;
import org.csu.greenfarm.domain.PreOrder;

import java.util.List;

public interface OrderService {
    /*
    预定订单和购买订单共用一个Service
     */

    List<PreOrder> getAllPreOrder(); //获取所有的订单
    List<PreOrder> getPreOrderByAccount(String account); //根据用户账户获取订单
    PreOrder getPreOrderByOrderId(String orderId);
    void delectOrder(String orderId); //删除预定订单
    void insertPreOrder(PreOrder order); //插入预定订单



    List<BuyOrder> getAllBuyOrder(); //获取所有的订单
    List<BuyOrder> getBuyOrderByAccount(String account); //根据用户账户获取订单
    void delectBuyOrder(String orderId); //删除预定订单
    BuyOrder getBuyOrderByOrderId(String orderId); //根据订单Id返回预定订单
    void insertBuyOrder(BuyOrder order); //插入订单

    void insertOrderItem(OrderItem item); //插入订单项目


    List<OrderItem> getOrderItemByOrderId(String orderId);

    String setOrderId();//随机生成订单号
}
