package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.BuyOrder;

import java.util.List;

public interface BuyOrderMapper {
    List<BuyOrder> getAllBuyOrder(); //获取所有的订单
    List<BuyOrder> getBuyOrderByAccount(String account); //根据用户账户获取订单
    void delectBuyOrder(String orderId); //删除预定订单
    BuyOrder getBuyOrderByOrderId(String orderId); //根据订单Id返回预定订单
    void insertBuyOrder(BuyOrder order); //删除预定订单
}
