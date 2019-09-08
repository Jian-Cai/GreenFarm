package org.csu.greenfarm.persistence;

import org.csu.greenfarm.domain.OrderItem;

import java.util.List;

public interface OrderMapper {
    List<OrderItem> getOrderItemByOrderId(String orderId);
    void insertOrderItem(OrderItem orderItem);
}
