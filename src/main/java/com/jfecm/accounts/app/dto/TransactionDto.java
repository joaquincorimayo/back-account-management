package com.jfecm.accounts.app.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jfecm.accounts.app.enums.TypeTransaction;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TransactionDto extends BaseDto<Long> {
    private TypeTransaction type;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
    private float amount = 0f;
    @JsonBackReference
    private AccountDto accountDto = new AccountDto();
}
