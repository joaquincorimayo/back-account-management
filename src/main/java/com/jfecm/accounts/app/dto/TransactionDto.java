package com.jfecm.accounts.app.dto;

import com.jfecm.accounts.app.enums.TransactionStatus;
import com.jfecm.accounts.app.enums.TypeTransaction;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TransactionDto extends BaseDto<Long> {
    private TypeTransaction type;
    private LocalDate date;
    private LocalTime time;
    private float amount;
    private TransactionStatus status;
    private String madeBy;
}
