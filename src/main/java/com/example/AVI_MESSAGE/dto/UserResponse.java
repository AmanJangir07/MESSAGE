package com.example.AVI_MESSAGE.dto;

public class UserResponse {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String token;

    // ---------------- GETTERS ----------------

    public Long getId() {
        return id;
    }

    public String getToken(){
        return token;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    // ---------------- SETTERS ----------------

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}