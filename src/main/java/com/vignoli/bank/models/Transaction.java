package com.vignoli.bank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
    private Integer id;
    private String action;
    private Double oldBalance;
    private Double newBalance;

    public Transaction() {
    }

    public Transaction(Integer id, String action, Double oldBalance, Double newBalance) {
        this.id = id;
        this.action = action;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
    }

    public Integer getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public Double getOldBalance() {
        return oldBalance;
    }

    public Double getNewBalance() {
        return newBalance;
    }


}
