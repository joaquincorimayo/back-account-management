package com.jfecm.accounts.app.repository;

import com.jfecm.accounts.app.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
}
