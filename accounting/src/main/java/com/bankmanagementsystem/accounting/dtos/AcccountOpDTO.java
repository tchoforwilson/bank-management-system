package com.bankmanagementsystem.accounting.dtos;

import java.util.Date;

public class AcccountOpDTO {
    private Double amount;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;


    public AcccountOpDTO(Double amount, Date createdAt, String createdBy, String updatedBy, Date updatedAt) {
        this.amount = amount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    
    
}
