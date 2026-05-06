package com.example.AVI_MESSAGE.dto;

public class ResetPasswordRequest {

    private String email;
    private String otp;
    private String newPassword;

    // ---------------- GETTERS ----------------

    public String getEmail() {
        return email;
    }

    public String getOtp() {
        return otp;
    }

    public String getNewPassword() {
        return newPassword;
    }

    // ---------------- SETTERS ----------------

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}