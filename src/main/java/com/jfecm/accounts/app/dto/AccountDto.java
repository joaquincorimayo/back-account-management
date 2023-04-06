package com.jfecm.accounts.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto extends BaseDto<Long> {
    private String accountNumber;
}
