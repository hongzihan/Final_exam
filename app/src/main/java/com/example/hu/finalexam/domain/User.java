package com.example.hu.finalexam.domain;

/**
 * Created by ken on 2018/1/11.
 */

public class User{
    private static String account;
    private static String username;
    private static String password;
    private static Integer balance;
    private static Integer id;
    private static String minSpeed="0";
    private static String maxSpeed="120";
    private static int autoLogin=-1;

    public static int getAutoLogin() {
        return autoLogin;
    }

    public static void setAutoLogin(int autoLogin) {
        User.autoLogin = autoLogin;
    }

    public static Integer getMinSpeed() {
        return Integer.parseInt(minSpeed);
    }

    public static void setMinSpeed(String minSpeed) {
        User.minSpeed = minSpeed;
    }

    public static Integer getMaxSpeed() {
        return Integer.parseInt(maxSpeed);
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
