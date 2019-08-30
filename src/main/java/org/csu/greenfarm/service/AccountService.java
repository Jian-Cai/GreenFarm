/*
 * Copyright (c) 2019
 * User: Duo.y
 * File:AccountService.java
 * Date:2019/08/30 21:42:30
 */

package org.csu.greenfarm.service;

import org.csu.greenfarm.domain.Account;

import java.util.List;

public interface AccountService {
    Account getAccountByAccount(String account); //根据账号返回用户信息
    Account getAccountByMail(String mail); //根据邮箱返回用户信息
    Account getAccountByUsername(String username); //根据昵称返回用户信息
    List<Account> getAccounts(); //返回所有的用户信息
}
