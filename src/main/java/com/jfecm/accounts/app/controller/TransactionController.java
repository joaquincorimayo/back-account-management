package com.jfecm.accounts.app.controller;

import com.jfecm.accounts.app.dto.AccountDto;
import com.jfecm.accounts.app.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final AccountService accountService;

    @PostMapping("/account/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable(name = "id") Long account,
                                              @RequestParam(value = "amount") float amount) {
        AccountDto operation = accountService.deposit(account, amount);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping("/account/{id}/transfer")
    public ResponseEntity<AccountDto> transfer(@PathVariable(name = "id") Long accountOrigin,
                                               @RequestParam(value = "to") Long accountTarget,
                                               @RequestParam(value = "amount") float amount) {
        AccountDto operation = accountService.transfer(accountOrigin, accountTarget, amount);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }


}
