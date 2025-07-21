package com.vignoli.bank.repositories;

import com.vignoli.bank.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Account, Integer> {
}
