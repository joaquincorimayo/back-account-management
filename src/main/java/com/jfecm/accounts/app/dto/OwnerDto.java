package com.jfecm.accounts.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerDto extends BaseDto<Long> {
    private String name;
    private String surname;
    private String dni;
    private String email;
    private String address;
    @JsonIgnore
    private AccountDto account = new AccountDto();
}
