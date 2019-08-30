/*
 * Copyright (c) 2019
 * User: Duo.y
 * File:Account.java
 * Date:2019/08/30 21:35:30
 */

package org.csu.greenfarm.domain;


public class Account implements java.io.Serializable{
    private String account; //账户
    private String username; //昵称
    private String password; //密码
    private String head; //头像
    private String recadd; //收货地址
    private String mail; //邮箱

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getRecadd() {
        return recadd;
    }

    public void setRecadd(String recadd) {
        this.recadd = recadd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
