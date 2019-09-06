package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.PreOrder;

import java.util.List;

public interface PreOrderMapper {

    List<PreOrder> getAllPreOrder(); //获取所有的订单
    List<PreOrder> getPreOrderByAccount(String account); //根据用户账户获取订单
    void delectPreOrder(String orderId); //删除预定订单
    PreOrder getPreOrderByOrderId(String orderId); //根据订单Id返回预定订单
    void insertPreOrder(PreOrder order); //删除预定订单
}
