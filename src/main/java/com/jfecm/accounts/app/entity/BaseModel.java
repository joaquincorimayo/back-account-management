package com.jfecm.accounts.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class BaseModel<I extends Number> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private I id;
    private Boolean isEnabled = Boolean.TRUE;
}
