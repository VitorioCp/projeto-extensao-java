package com.example.demo.model;

public class User {
    private Integer id;
    private String login;
    private String password;
    public User(){}
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
    @Override
    public String toString(){
        return "User{" + 
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        '}';
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
    
}
