package com.bankmanagementsystem.accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

import com.bankmanagementsystem.auth.models.User;

import java.util.Random;
import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;

    @NotBlank(message = "Account must belong to a user")
    @Field("userId")
    private User user;

    @NotBlank(message = "Account must an account number")
    @Indexed(unique = true)
    @Field("accountNumber")
    private String accountNumber;

    @Field("balance")
    private Double balance;

    @NotBlank(message = "Account must have a currency")
    @Field("Currency")
    private String currency;

     @Field("createdAt")
    private Date createdAt;

    @Field("updatedAt")
    private Date updatedAt;

    @Field("createdBy")
    private String createdBy;

    @Field("updatedBy")
    private String updatedBy;

    public Account(String userId, String currency, String createdBy) {
        this.userId = userId;
        this.accountNumber = generateAccountNumber();
        this.currency = currency;
        this.createdBy = createdBy;
        this.updatedBy = createdBy; 
        this.createdAt = Date.now();
        this.updatedAt = Date.now();
    }

    private String generateAccountNumber() {
        Random random = new Random();
        return String.format("%010d", random.nextInt(1000000000)); // Generates a random 10-digit number
    }

    public void deposit(double amount, String updatedBy) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
        this.balance += amount;
        this.updatedAt = Date.now();
        this.updatedBy = updatedBy;
    }

    public void withdraw(double amount, String updatedBy) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }
        if (amount > this.balance) {
            throw new IllegalStateException("Insufficient balance for withdrawal");
        }
        this.balance -= amount;
        this.updatedAt = Date.now();
        this.updatedBy = updatedBy;
    }

    public void transfer(Account toAccount, double amount, String updatedBy) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than 0");
        }
        if (amount > this.balance) {
            throw new IllegalStateException("Insufficient balance for transfer");
        }
        this.withdraw(amount, updatedBy);
        toAccount.deposit(amount, updatedBy);
    }

    public Double getBalance() {
        return balance;
    }
}
