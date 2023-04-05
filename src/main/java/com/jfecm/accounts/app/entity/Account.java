package com.jfecm.accounts.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account extends BaseModel<Long> {
    private String accountNumber;
    private LocalDateTime openDate;
    private Float currentBalance;
    private Float accountLimit;
}
