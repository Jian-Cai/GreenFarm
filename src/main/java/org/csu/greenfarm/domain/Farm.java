/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: Farm.java
 * Date: 2019/09/02 15:24:02
 */

package org.csu.greenfarm.domain;

public class Farm implements java.io.Serializable{
    private String farmId; //农场ID
    private String farm_name; //采摘园名称
    private String farm_address; //采摘园地址
    private String farm_time; //采摘园开放时间
    private String farm_phone; //采摘园联系电话
    private String farm_photo; //采摘园预览图
    private String farm_item; //采摘园主营业务
    private double farm_price; //采摘园价格 */人
    private String farm_item_short; //采摘园主营业务的删减版 字符≤8。

    public String getFarm_item_short() {
        return farm_item_short;
    }

    public void setFarm_item_short(String farm_item_short) {
        this.farm_item_short = farm_item_short;
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public String getFarm_name() {
        return farm_name;
    }

    public void setFarm_name(String farm_name) {
        this.farm_name = farm_name;
    }

    public String getFarm_address() {
        return farm_address;
    }

    public void setFarm_address(String farm_address) {
        this.farm_address = farm_address;
    }

    public String getFarm_time() {
        return farm_time;
    }

    public void setFarm_time(String farm_time) {
        this.farm_time = farm_time;
    }

    public String getFarm_phone() {
        return farm_phone;
    }

    public void setFarm_phone(String farm_phone) {
        this.farm_phone = farm_phone;
    }

    public String getFarm_photo() {
        return farm_photo;
    }

    public void setFarm_photo(String farm_photo) {
        this.farm_photo = farm_photo;
    }

    public String getFarm_item() {
        return farm_item;
    }

    public void setFarm_item(String farm_item) {
        this.farm_item = farm_item;
    }

    public double getFarm_price() {
        return farm_price;
    }

    public void setFarm_price(double farm_price) {
        this.farm_price = farm_price;
    }
}
