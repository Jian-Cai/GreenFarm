package org.csu.greenfarm.domain;

import java.util.Date;

public class FarmComment implements java.io.Serializable{
    private String farmcomId;
    private String farmcom_username;
    private String farmcom_farmId;
    private Date farmcom_time;
    private String farmcom_comment;
    private String farmcom_photo;


    public String getFarmcomId() {
        return farmcomId;
    }

    public void setFarmcomId(String farmcomId) {
        this.farmcomId = farmcomId;
    }

    public String getFarmcom_username() {
        return farmcom_username;
    }

    public void setFarmcom_username(String farmcom_username) {
        this.farmcom_username = farmcom_username;
    }

    public String getFarmcom_farmId() {
        return farmcom_farmId;
    }

    public void setFarmcom_farmId(String farmcom_farmId) {
        this.farmcom_farmId = farmcom_farmId;
    }

    public Date getFarmcom_time() {
        return farmcom_time;
    }

    public void setFarmcom_time(Date farmcom_time) {
        this.farmcom_time = farmcom_time;
    }

    public String getFarmcom_comment() {
        return farmcom_comment;
    }

    public void setFarmcom_comment(String farmcom_comment) {
        this.farmcom_comment = farmcom_comment;
    }

    public String getFarmcom_photo() {
        return farmcom_photo;
    }

    public void setFarmcom_photo(String farmcom_photo) {
        this.farmcom_photo = farmcom_photo;
    }
}
