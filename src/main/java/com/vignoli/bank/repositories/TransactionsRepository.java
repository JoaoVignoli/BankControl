package com.vignoli.bank.repositories;

import com.vignoli.bank.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transaction, Integer> {
}
