package com.jfecm.accounts.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends BaseModel<Long> {
    private String name;
    private String surname;
    @Column(unique = true)
    private String dni;
    @Column(unique = true)
    private String email;
    private String address;
    @OneToOne(mappedBy = "owner")
    private Account account;
}
