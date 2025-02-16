package com.bankmanagementsystem.auth.dto;

public class UpdatePasswordDTO {
    private String currentPassord;
    private String newPassword;
    private String confirmPassword;

    public UpdatePasswordDTO(String currentPassord, String newPassword, String confirmPassword) {
        this.currentPassord = currentPassord;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getCurrentPassord() {
        return currentPassord;
    }

    public void setCurrentPassord(String currentPassord) {
        this.currentPassord = currentPassord;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
