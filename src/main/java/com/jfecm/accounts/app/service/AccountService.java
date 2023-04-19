package com.jfecm.accounts.app.service;

import com.jfecm.accounts.app.dto.AccountDto;
import com.jfecm.accounts.app.entity.Account;
import com.jfecm.accounts.app.mapper.AccountMapper;
import com.jfecm.accounts.app.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService<Account, Long, AccountDto> implements IAccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    public AccountService(BaseRepository<Account, Long> repository) {
        super(repository);
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
}
