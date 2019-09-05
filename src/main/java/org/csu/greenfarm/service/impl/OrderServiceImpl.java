package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.BuyOrder;
import org.csu.greenfarm.domain.PreOrder;
import org.csu.greenfarm.persistence.BuyOrderMapper;
import org.csu.greenfarm.persistence.PreOrderMapper;
import org.csu.greenfarm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PreOrderMapper preOrderMapper;

    @Autowired
    private BuyOrderMapper buyOrderMapper;

    @Override
    public List<PreOrder> getAllPreOrder() {
        return orderByDate(preOrderMapper.getAllPreOrder());
    }

    @Override
    public List<PreOrder> getPreOrderByAccount(String account) {
        return orderByDate(preOrderMapper.getPreOrderByAccount(account));
    }

    @Override
    public List<BuyOrder> getAllBuyOrder() {
        return orderByDate2(buyOrderMapper.getAllPreOrder());
    }

    @Override
    public List<BuyOrder> getBuyOrderByAccount(String account) {
        return orderByDate2(buyOrderMapper.getPreOrderByAccount(account));
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


}
