package com.jfecm.accounts.app.controller;

import com.jfecm.accounts.app.dto.AccountDto;
import com.jfecm.accounts.app.entity.Account;
import com.jfecm.accounts.app.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/accounts")
public class AccountController extends BaseController<Account, Long, AccountDto> {

    @Autowired
    protected AccountController(BaseService<Account, Long, AccountDto> service) {
        super(service);
    }
}
