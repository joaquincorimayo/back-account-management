package com.jfecm.accounts.app.service;

import com.jfecm.accounts.app.dto.AccountDto;
import com.jfecm.accounts.app.entity.Account;
import com.jfecm.accounts.app.entity.Transaction;
import com.jfecm.accounts.app.enums.TransactionStatus;
import com.jfecm.accounts.app.enums.TypeTransaction;
import com.jfecm.accounts.app.exception.AccountAvailableBalanceException;
import com.jfecm.accounts.app.mapper.AccountMapper;
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

    @Autowired
    public AccountService(BaseRepository<Account, Long> repository, AccountMapper accountMapper) {
        super(repository);
        this.accountMapper = accountMapper;
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
        Account account = findByIdEntity(id);
        addTransaction(account, amount, account.getAccountNumber(), TypeTransaction.DEPOSIT);
        Float actual = account.getCurrentBalance() + amount;
        account.setCurrentBalance(actual);
        return save(entityToDTO(account));
    }

    @Override
    public AccountDto transfer(Long origin, Long target, float amount) {
        Account accountOrigin = findByIdEntity(origin);

        if (amount > accountOrigin.getCurrentBalance()) {
            throw new AccountAvailableBalanceException("The account does not have the balance available for the operation. Actual Balance: " + accountOrigin.getCurrentBalance());
        }

        Account accountTarget = findByIdEntity(target);
        addTransaction(accountOrigin, amount, accountOrigin.getAccountNumber(), TypeTransaction.TRANSFER);
        Float actualOrigin = accountOrigin.getCurrentBalance() - amount;
        accountOrigin.setCurrentBalance(actualOrigin);
        addTransaction(accountTarget, amount, accountOrigin.getAccountNumber(), TypeTransaction.TRANSFER);
        Float actualTarget = accountTarget.getCurrentBalance() + amount;
        accountTarget.setCurrentBalance(actualTarget);

        save(entityToDTO(accountTarget));
        return save(entityToDTO(accountOrigin));
    }

    @Override
    public AccountDto extraction(Long id, float amount) {
        Account account = findByIdEntity(id);
        if (amount > account.getCurrentBalance()) {
            throw new AccountAvailableBalanceException("The account does not have the balance available for the operation. Actual Balance: " + account.getCurrentBalance());
        }
        addTransaction(account, amount, account.getAccountNumber(), TypeTransaction.EXTRACTION);
        Float actualBalance = account.getCurrentBalance() - amount;
        account.setCurrentBalance(actualBalance);
        return save(entityToDTO(account));
    }

    private void addTransaction(Account account, Float amount, String madeBy, TypeTransaction typeTransaction) {
        Transaction transactionTarget = new Transaction();
        transactionTarget.setType(typeTransaction);
        transactionTarget.setDate(LocalDate.now());
        transactionTarget.setTime(LocalTime.now());
        transactionTarget.setAmount(amount);
        transactionTarget.setStatus(TransactionStatus.SUCCESS);
        transactionTarget.setMadeBy(madeBy);
        account.getTransactions().add(transactionTarget);
    }


}
