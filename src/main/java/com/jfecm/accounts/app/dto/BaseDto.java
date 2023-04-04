package com.jfecm.accounts.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class BaseDto<I extends Number> {
    private I id;
    private Boolean isEnabled = Boolean.TRUE;
}
