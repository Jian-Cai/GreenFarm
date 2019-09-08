package org.csu.greenfarm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuyOrder implements java.io.Serializable {
    private String buyorderId; //购买订单ID
    private String buy_account; //购买人
    private int buy_period; //运货周期
    private Date buy_date; //购买时间
    private List<Object> products;

    public List<Object> getProducts() {
        return products;
    }

    public void setProducts(List<Object> products) {
        this.products = new ArrayList<>(products);
    }

    public String getBuyorderId() {
        return buyorderId;
    }

    public void setBuyorderId(String buyorderId) {
        this.buyorderId = buyorderId;
    }


    public String getBuy_account() {
        return buy_account;
    }

    public void setBuy_account(String buy_account) {
        this.buy_account = buy_account;
    }


    public int getBuy_period() {
        return buy_period;
    }

    public void setBuy_period(int buy_period) {
        this.buy_period = buy_period;
    }

    public Date getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(Date buy_date) {
        this.buy_date = buy_date;
    }
}
