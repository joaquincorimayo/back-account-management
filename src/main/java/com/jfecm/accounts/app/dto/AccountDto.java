package com.jfecm.accounts.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class AccountDto extends BaseDto<Long> {
    private LocalDateTime openDate = LocalDateTime.now();
    private String accountNumber;
    private OwnerDto owner;
    private List<TransactionDto> transactions = new ArrayList<>();
    private Float currentBalance = 0f;
    private Float accountLimit = 0f;
}
