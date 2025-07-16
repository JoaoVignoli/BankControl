package com.vignoli.bank.models;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

public class Account {
    private Integer id;
    private Client client;
    private Double balance;
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(Client client, Integer id) {
        this.client = client;
        this.id = id;
        this.balance = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(Double value) {
        Transaction transaction = new Transaction(transactions.size() + 1, "Deposit", balance, balance + value);
        transactions.add(transaction);
        balance += value;
    }

    public void withdraw(Double value) {
        if (balance > 0) {
            Transaction transaction = new Transaction(transactions.size() + 1, "Withdraw", balance, balance - value);
            transactions.add(transaction);
            balance -= value;
        } else {
            System.out.println("Saldo Insuficiente para Saque.");
        }
    }
}
