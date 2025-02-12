package com.bankmanagementsystem.auth.dto;

public class RegisterUserDTO {
    private String email;

    private String password;

    private String name;

    public RegisterUserDTO() {
        this.email = "";
        this.password = "";
        this.name = "";
    }

    public RegisterUserDTO(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
