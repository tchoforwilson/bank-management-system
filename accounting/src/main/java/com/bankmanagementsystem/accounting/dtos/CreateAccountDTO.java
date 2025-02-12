package com.bankmanagementsystem.accounting.dtos;

public class CreateAccountDTO {
    private String currency;

    private String userId;

    public CreateAccountDTO(String currency, String userId) {
        this.currency = currency;
        this.userId = userId;
    }

    public String getCurrency() {
        return currency;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
