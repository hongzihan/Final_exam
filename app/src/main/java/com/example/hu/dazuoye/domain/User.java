package com.example.hu.dazuoye.domain;

/**
 * Created by ken on 2018/1/6.
 */

public class User {

    private String username;
    private String account;
    private String password;
    private Integer id;
    private Integer balance;


    public User(String username, String account, String password, Integer id, Integer balance){
        this.username = username;
        this.account = account;
        this.password = password;
        this.id = id;
        this.balance = balance;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}

