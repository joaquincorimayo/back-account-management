package com.jfecm.accounts.app.service;

import com.jfecm.accounts.app.dto.AccountDto;
import com.jfecm.accounts.app.entity.Account;

public interface IAccountService extends IBaseService<Account, Long, AccountDto> {
    AccountDto deposit(Long id, float amount);
    AccountDto transfer(Long origin, Long target, float amount);
}
