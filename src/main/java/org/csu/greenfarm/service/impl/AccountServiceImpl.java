/*
 * Copyright (c) 2019
 * User: Duo.y
 * File:AccountServiceImpl.java
 * Date:2019/08/30 21:43:30
 */

package org.csu.greenfarm.service.impl;

import org.csu.greenfarm.domain.Account;
import org.csu.greenfarm.persistence.AccountMapper;
import org.csu.greenfarm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper mapper;

    @Override
    public Account getAccount(String user) {
        return mapper.getAccountByAccount(user) == null ? (mapper.getAccountByMail(user) == null ? mapper.getAccountByUsername(user) : mapper.getAccountByMail(user)) : mapper.getAccountByAccount(user);
    }



    @Override
    public List<Account> getAccounts() {
        return mapper.getAccounts();
    }
}
