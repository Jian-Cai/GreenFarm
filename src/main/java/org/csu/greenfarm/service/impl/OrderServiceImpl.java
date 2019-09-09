package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.BuyOrder;
import org.csu.greenfarm.domain.OrderItem;
import org.csu.greenfarm.domain.PreOrder;
import org.csu.greenfarm.domain.Product;
import org.csu.greenfarm.persistence.*;
import org.csu.greenfarm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PreOrderMapper preOrderMapper;

    @Autowired
    private BuyOrderMapper buyOrderMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private FarmMapper farmMapper;

    @Override
    public List<Object> getProductByOrderId(String orderId) {
        List<OrderItem> orderItems = orderMapper.getOrderItemByOrderId(orderId);
        List<Object> products = new ArrayList<>();
        for(int a = 0; a < orderItems.size(); a++){
            if(productMapper.getProductByProductId(orderItems.get(a).getProductId()) == null){
                products.add(farmMapper.getFarmByFarmId(orderItems.get(a).getProductId()));
            }
            else products.add(productMapper.getProductByProductId(orderItems.get(a).getProductId()));
        }
        return products;
    }

    @Override
    public List<PreOrder> getAllPreOrder() {
        return orderByDate(preOrderMapper.getAllPreOrder());
    }

    @Override
    public List<PreOrder> getPreOrderByAccount(String account) {
        return orderByDate(preOrderMapper.getPreOrderByAccount(account));
    }

    @Override
    public PreOrder getPreOrderByOrderId(String orderId) {
        return preOrderMapper.getPreOrderByOrderId(orderId);
    }

    @Override
    public void delectOrder(String orderId) {
        if(preOrderMapper.getPreOrderByOrderId(orderId) == null){

        }
        else {
            preOrderMapper.delectPreOrder(orderId);
        }
    }

    @Override
    public void insertPreOrder(PreOrder order) {
        preOrderMapper.insertPreOrder(order);
    }


    @Override
    public List<BuyOrder> getAllBuyOrder() {
        return orderByDate2(buyOrderMapper.getAllBuyOrder());
    }

    @Override
    public List<BuyOrder> getBuyOrderByAccount(String account) {
        return orderByDate2(buyOrderMapper.getBuyOrderByAccount(account));
    }

    @Override
    public void delectBuyOrder(String orderId) {
        buyOrderMapper.delectBuyOrder(orderId);
    }

    @Override
    public BuyOrder getBuyOrderByOrderId(String orderId) {
        return buyOrderMapper.getBuyOrderByOrderId(orderId);
    }

    @Override
    public void insertOrderItem(OrderItem item) {
        orderMapper.insertOrderItem(item);
    }

    @Override
    public void insertBuyOrder(BuyOrder order) {
        buyOrderMapper.insertBuyOrder(order);
    }

    @Override
    public List<OrderItem> getOrderItemByOrderId(String orderId) {
        return orderMapper.getOrderItemByOrderId(orderId);
    }

    //根据预定订单时间排序
    public List<PreOrder> orderByDate(List<PreOrder> list){
        Comparator<PreOrder> o = new Comparator<PreOrder>(){
            @Override
            public int compare(PreOrder d1, PreOrder d2) {
                if(d1.getPre_time().before(d2.getPre_time())) {
                    return 1;
                }else {
                    return -1;
                }
            }
        };
        Collections.sort(list, o);
        return list;
    }
    public List<BuyOrder> orderByDate2(List<BuyOrder> list){
        Comparator<BuyOrder> o = new Comparator<BuyOrder>(){
            @Override
            public int compare(BuyOrder d1, BuyOrder d2) {
                if(d1.getBuy_date().before(d2.getBuy_date())) {
                    return 1;
                }else {
                    return -1;
                }
            }
        };
        Collections.sort(list, o);
        return list;
    }

    //随机生成订单号
    @Override
    public String setOrderId(){
        int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
        int r2=(int)(Math.random()*(10));
        long now = System.currentTimeMillis()%1000000000;//一个10位的时间戳
        String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);
        return paymentID;
    }


}
