package com.jfecm.accounts.app.entity;

import com.jfecm.accounts.app.enums.TransactionStatus;
import com.jfecm.accounts.app.enums.TypeTransaction;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction extends BaseModel<Long> {
    @Enumerated(value = EnumType.STRING)
    private TypeTransaction type;
    private LocalDate date;
    private LocalTime time;
    private float amount = 0f;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;
    private String madeBy;
}
