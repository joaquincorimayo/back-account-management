package com.jfecm.accounts.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account extends BaseModel<Long> {
    @Column(unique = true)
    private String accountNumber;
    private LocalDateTime openDate;
    private Float currentBalance = 0f;
    private Float accountLimit = 0f;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private List<Transaction> transactions = new ArrayList<>();
}
