package org.csu.greenfarm.domain;

import java.util.Date;

public class Check {
    private String checkId;
    private String check_item;
    private Date check_date;
    private String check_result;
    private String check_origin;

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getCheck_item() {
        return check_item;
    }

    public void setCheck_item(String check_item) {
        this.check_item = check_item;
    }

    public Date getCheck_date() {
        return check_date;
    }

    public void setCheck_date(Date check_date) {
        this.check_date = check_date;
    }

    public String getCheck_result() {
        return check_result;
    }

    public void setCheck_result(String check_result) {
        this.check_result = check_result;
    }

    public String getCheck_origin() {
        return check_origin;
    }

    public void setCheck_origin(String check_origin) {
        this.check_origin = check_origin;
    }
}
