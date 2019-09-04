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
    public Account getAccountByAccount(String account) {
        return mapper.getAccountByAccount(account);
    }

    @Override
    public Account getAccountByMail(String mail) {
        return mapper.getAccountByMail(mail);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return mapper.getAccountByUsername(username);
    }

    @Override
    public List<Account> getAccounts() {
        return mapper.getAccounts();
    }

    @Override
    public void signOn(Account account) {
        mapper.signOn(account);
    }

}
