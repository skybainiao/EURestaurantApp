package com.example.eurestaurant.Model;

public class Account {
    private String username;
    private String password;
    private String status;


    public Account(String username,String password,String status){
        this.username=username;
        this.password=password;
        this.status=status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
