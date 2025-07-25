package com.vignoli.bank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    private Integer id;
    private String name;
    private String taxId;

    public Client() {
    }

    public Client(Integer id, String name, String taxId) {
        this.id = id;
        this.name = name;
        this.taxId = taxId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
}
