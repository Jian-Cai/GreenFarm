package org.csu.greenfarm.domain;

import java.util.Date;

public class PreOrder implements java.io.Serializable {
    private String preorderId; //预定订单Id
    private Date pre_time; //预定订单时间
    private String pre_account; //预定订单所属用户账户名
    private String remarks; //备注

    public String getPreorderId() {
        return preorderId;
    }

    public void setPreorderId(String preorderId) {
        this.preorderId = preorderId;
    }

    public Date getPre_time() {
        return pre_time;
    }

    public void setPre_time(Date pre_time) {
        this.pre_time = pre_time;
    }

    public String getPre_account() {
        return pre_account;
    }

    public void setPre_account(String pre_account) {
        this.pre_account = pre_account;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
