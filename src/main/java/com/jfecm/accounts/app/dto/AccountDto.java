package com.jfecm.accounts.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto extends BaseDto<Long> {
    private String accountNumber;
    private OwnerDto owner;
    private LocalDateTime openDate = LocalDateTime.now();
}
