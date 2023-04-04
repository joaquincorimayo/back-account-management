package com.jfecm.accounts.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "owners")
public class Owner extends BaseModel<Long> {
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String address;
}
