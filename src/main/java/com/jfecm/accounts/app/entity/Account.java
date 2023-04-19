package com.jfecm.accounts.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account extends BaseModel<Long> {
    @Column(unique = true)
    private String accountNumber;
    private LocalDateTime openDate;
    private Float currentBalance;
    private Float accountLimit;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;
}
