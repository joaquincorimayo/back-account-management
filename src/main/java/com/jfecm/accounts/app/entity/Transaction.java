package com.jfecm.accounts.app.entity;

import com.jfecm.accounts.app.enums.TypeTransaction;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction extends BaseModel<Long> {
    @Enumerated(value = EnumType.STRING)
    private TypeTransaction type;
    private LocalDate date;
    private LocalTime time;
    private float amount = 0f;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
}
