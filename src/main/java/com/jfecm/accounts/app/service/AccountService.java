package com.jfecm.accounts.app.service;

import com.jfecm.accounts.app.dto.AccountDto;
import com.jfecm.accounts.app.entity.Account;
import com.jfecm.accounts.app.entity.Transaction;
import com.jfecm.accounts.app.enums.TypeTransaction;
import com.jfecm.accounts.app.mapper.AccountMapper;
import com.jfecm.accounts.app.mapper.TransactionMapper;
import com.jfecm.accounts.app.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Slf4j
@Service
public class AccountService extends BaseService<Account, Long, AccountDto> implements IAccountService {
    private final AccountMapper accountMapper;
    private final TransactionMapper transactionMapper;

    @Autowired
    public AccountService(BaseRepository<Account, Long> repository, AccountMapper accountMapper, TransactionMapper transactionMapper) {
        super(repository);
        this.accountMapper = accountMapper;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Account dtoToEntity(AccountDto element) {
        return accountMapper.unMap(element);
    }

    @Override
    public Account dtoToEntityUpdate(Account account, AccountDto accountDto) {
        return accountMapper.unMap(account, accountDto);
    }

    @Override
    public AccountDto entityToDTO(Account element) {
        return accountMapper.map(element);
    }

    @Override
    public AccountDto deposit(Long id, float amount) {
        // TODO : MAKE TRANSACTION SAVE.
        AccountDto accountDto = findById(id);
        Float actual = accountDto.getCurrentBalance() + amount;
        accountDto.setCurrentBalance(actual);
        Transaction transaction = new Transaction();
        transaction.setIsEnabled(true);
        transaction.setType(TypeTransaction.DEPOSIT);
        transaction.setDate(LocalDate.now());
        transaction.setTime(LocalTime.now());
        transaction.setAmount(amount);
        transaction.setAccount(dtoToEntity(accountDto));
        accountDto.getTransactions().add(transactionMapper.map(transaction));
        return save(accountDto);
    }

    @Override
    public AccountDto transfer(Long origin, Long target, float amount) {
        // TODO
        return null;
    }
}
