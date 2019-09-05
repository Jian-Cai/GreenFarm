/*
 * Copyright (c) 2019
 * User: Duo.y
 * File: Product.java
 * Date: 2019/09/03 14:38:03
 */

package org.csu.greenfarm.domain;

public class Product implements java.io.Serializable{
    private String productId; //农产品ID
    private String product_name; //农产品名称
    private double product_price; //农产品价格
    private String product_photo; //农产品图片
    private String product_origin; //农产品种植园（所属采摘园）
    private String product_check; //农产品检测结果 结果为null则显示目前即将上架
    private String product_category; //农产品分类

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_photo() {
        return product_photo;
    }

    public void setProduct_photo(String product_photo) {
        this.product_photo = product_photo;
    }

    public String getProduct_origin() {
        return product_origin;
    }

    public void setProduct_origin(String product_origin) {
        this.product_origin = product_origin;
    }

    public String getProduct_check() {
        return product_check;
    }

    public void setProduct_check(String product_check) {
        this.product_check = product_check;
    }
}
