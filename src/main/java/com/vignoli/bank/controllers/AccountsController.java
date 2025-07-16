package com.vignoli.bank.controllers;

import com.vignoli.bank.models.Account;
import com.vignoli.bank.models.Client;
import com.vignoli.bank.models.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
    private final ArrayList<Account> accounts = new ArrayList<>();

    public AccountsController() {
        Client client1 = new Client(1, "João Victor Vignoli", "12345678987");
        Client client2 = new Client(2, "Rodolfo Pereira", "78945612354");

        Account account1 = new Account(client1, 1);
        Account account2 = new Account(client2, 2);

        account1.deposit(100.0);
        account1.withdraw(20.65);
        account1.deposit(345.65);

        account2.deposit(65.90);
        account2.deposit(1000.89);
        account2.withdraw(1.0);

        accounts.add(account1);
        accounts.add(account2);
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accounts;
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Integer accountId) {
        for (Account account: accounts) {
            if (Objects.equals(account.getId(), accountId)) {
                return account;
            }
        }
        return null;
    }

    @GetMapping("/{accountId}/balance")
    public Double getBalance(@PathVariable Integer accountId) {
        for (Account account: accounts) {
            if (Objects.equals(account.getId(), accountId)) {
                return account.getBalance();
            }
        }
        return null;
    }

    @GetMapping("/{accountId}/transactions")
    public List<Transaction> getTrasactions(@PathVariable Integer accountId) {
        for (Account account: accounts) {
            if (Objects.equals(account.getId(), accountId)) {
                return account.getTransactions();
            }
        }
        return null;
    }

    @GetMapping("/{accountId}/transactions/{transactionId}/details")
    public Transaction getTrasactionDetail(@PathVariable Integer accountId, @PathVariable Integer transactionId) {
        for (Account account: accounts) {
            if (Objects.equals(account.getId(), accountId)) {
                ArrayList<Transaction> accountTransactions = account.getTransactions();
                for (Transaction transaction: accountTransactions) {
                    if (Objects.equals(transaction.getId(), transactionId)) {
                        return transaction;
                    }
                }
            }
        }
        return null;
    }
}
