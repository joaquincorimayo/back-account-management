package com.jfecm.accounts.app.repository;

import com.jfecm.accounts.app.entity.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, Long> {
}
