package com.example.hu.dazuoye.domain;

import android.app.Application;

import com.example.hu.dazuoye.db.dao.UserDao;

/**
 * Created by ken on 2018/1/11.
 */

public class User{
    private static String account;
    private static String username;
    private static String password;
    private static Integer balance;
    private static Integer id;


    public static String getAccount() {
        return account;
    }

    public static void setAccount(String account) {
        User.account = account;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static Integer getBalance() {
        return balance;
    }

    public static void setBalance(Integer balance) {
        User.balance = balance;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        User.id = id;
    }
}
