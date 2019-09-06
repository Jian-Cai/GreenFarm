package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.BuyOrder;

import java.util.List;

public interface BuyOrderMapper {
    List<BuyOrder> getAllPreOrder(); //获取所有的订单
    List<BuyOrder> getBuyOrderByAccount(String account); //根据用户账户获取订单
}
