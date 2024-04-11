package com.example.vizsgaremek;

public class Users {
    public String email;
    public String username;
    public String password;
    public String passwordAgain;

    public Users(String email, String username, String password, String passwordAgain) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.passwordAgain = passwordAgain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }
}
