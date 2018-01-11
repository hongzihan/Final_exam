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
    private static int speedLimitFlag = -1;

    public static int getSpeedLimitFlag() {
        return speedLimitFlag;
    }

    public static void setSpeedLimitFlag(int speedLimitFlag) {
        User.speedLimitFlag = speedLimitFlag;
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
