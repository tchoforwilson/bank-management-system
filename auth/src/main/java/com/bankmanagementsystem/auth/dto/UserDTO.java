package com.bankmanagementsystem.auth.dto;

import java.util.Date;

public class UserDTO {

    private String id;

    private String email;

    private String name;

    private Date createdAt;

    private Date updatedAt;

    public UserDTO() {
        this.id = "";
        this.email = "";
        this.name = "";
    }

    public UserDTO(String id, String email, String name, Date createdAt, Date updatedAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
