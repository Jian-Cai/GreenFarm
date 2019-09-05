package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.PreOrder;

import java.util.List;

public interface PreOrderMapper {

    List<PreOrder> getAllPreOrder(); //获取所有的订单
    List<PreOrder> getPreOrderByAccount(String account); //根据用户账户获取订单
}
