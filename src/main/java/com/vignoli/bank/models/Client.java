package com.vignoli.bank.models;

public class Client {
    private Integer id;
    private String name;
    private String taxId;

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
}
