package com.civmodapi.DTOs;

public class UserRequestDTO {
    private String email;
    private String password;

    // Другие поля, связанные с пользователем, если необходимо


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
}
