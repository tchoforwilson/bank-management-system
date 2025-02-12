package com.bankmanagementsystem.auth.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private String id;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 30, max = 255, message = "Username must be between 30 and 255 characters")
    @Field("name")
    private String name;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Field("password")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Indexed(unique = true)
    @Field(name = "email")
    private String email;

    @Field(name = "createdAt")
    private Date createdAt;

    @Field("updatedAt")
    private Date updatedAt;

    @Field("createdBy")
    private String createdBy;

    @Field("updatedBy")
    private String updatedBy;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.createdBy = "system";
        this.updatedBy = "system";
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.createdBy = "system";
        this.updatedBy = "system";
    }

    public User() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.createdBy = "system";
        this.updatedBy = "system";
    }

    public User(
            @NotBlank(message = "Username cannot be blank") @Size(min = 30, max = 255, message = "Username must be between 30 and 255 characters") String name,
            @NotBlank(message = "Password cannot be blank") @Size(min = 8, message = "Password must be at least 8 characters") String password,
            @NotBlank(message = "Email cannot be blank") @Email(message = "Invalid email format") String email,
            Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Getters and setters for other fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
