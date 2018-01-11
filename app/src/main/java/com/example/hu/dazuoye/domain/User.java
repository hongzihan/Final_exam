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
    private static String minSpeed;
    private static String maxSpeed;


    public static String getMinSpeed() {
        return minSpeed;
    }

    public static void setMinSpeed(String minSpeed) {
        User.minSpeed = minSpeed;
    }

    public static String getMaxSpeed() {
        return maxSpeed;
    }

    public static void setMaxSpeed(String maxSpeed) {
        User.maxSpeed = maxSpeed;
    }



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
