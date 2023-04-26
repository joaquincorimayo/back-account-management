package com.jfecm.accounts.app.mapper;

import com.jfecm.accounts.app.dto.TransactionDto;
import com.jfecm.accounts.app.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends BaseMapper<Transaction, TransactionDto> {
}
