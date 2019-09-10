package org.csu.greenfarm.domain;

import java.util.Date;

public class ProductCom implements java.io.Serializable {
    private String productcomId;
    private String productcom_account;
    private String productcom_product;
    private Date productcom_time;
    private String productcom_comment;
    private String productcom_photo;

    public String getProductcomId() {
        return productcomId;
    }

    public void setProductcomId(String productcomId) {
        this.productcomId = productcomId;
    }

    public String getProductcom_account() {
        return productcom_account;
    }

    public void setProductcom_account(String productcom_account) {
        this.productcom_account = productcom_account;
    }

    public String getProductcom_product() {
        return productcom_product;
    }

    public void setProductcom_product(String productcom_product) {
        this.productcom_product = productcom_product;
    }

    public Date getProductcom_time() {
        return productcom_time;
    }

    public void setProductcom_time(Date productcom_time) {
        this.productcom_time = productcom_time;
    }

    public String getProductcom_comment() {
        return productcom_comment;
    }

    public void setProductcom_comment(String productcom_comment) {
        this.productcom_comment = productcom_comment;
    }

    public String getProductcom_photo() {
        return productcom_photo;
    }

    public void setProductcom_photo(String productcom_photo) {
        this.productcom_photo = productcom_photo;
    }
}
