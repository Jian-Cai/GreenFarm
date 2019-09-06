package org.csu.greenfarm.domain;

import java.util.Date;

public class BuyOrder implements java.io.Serializable {
    private String buyorderId; //购买订单ID
    private String buy_product; //购买商品
    private String buy_account; //购买人
    private int buy_amount; //购买数量
    private int buy_period; //运货周期
    private Date buy_date; //购买时间

    public String getBuyorderId() {
        return buyorderId;
    }

    public void setBuyorderId(String buyorderId) {
        this.buyorderId = buyorderId;
    }

    public String getBuy_product() {
        return buy_product;
    }

    public void setBuy_product(String buy_product) {
        this.buy_product = buy_product;
    }

    public String getBuy_account() {
        return buy_account;
    }

    public void setBuy_account(String buy_account) {
        this.buy_account = buy_account;
    }

    public int getBuy_amount() {
        return buy_amount;
    }

    public void setBuy_amount(int buy_amount) {
        this.buy_amount = buy_amount;
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
