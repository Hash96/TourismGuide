package com.example.login;

public class UserModel {
    private int id;
    private String username;
    private int password;

    public UserModel(int id, String username, int password) {
        this.id = id;
        username = username;
        password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", Username='" + username + '\'' +
                ", Password=" + password +
                '}';
    }

    public UserModel() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        username = username;
    }

    public void setPassword(Character password) {
        password = password;
    }
}
