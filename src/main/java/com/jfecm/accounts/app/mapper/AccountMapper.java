package com.jfecm.accounts.app.mapper;

import com.jfecm.accounts.app.dto.AccountDto;
import com.jfecm.accounts.app.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDto> {
}
