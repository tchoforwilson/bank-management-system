package com.bankmanagementsystem.accounting.dtos;

public class AccountDTO {
    private String id;

    private String accountNumber;

    private String currency;

    private Double balance;

    public AccountDTO(String id, String accountNumber, String currency, Double balance){
        this.id = id;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
    }

    // Getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public Double getBalance() {
        return balance;
    }
}
