package com.example.hu.finalexam.domain;

/**
 * Created by ken on 2018/1/15.
 */

public class SpeedLimit {


    private static String minSpeedLimitCarOne = "60";
    private static String maxSpeedLimitCarOne = "120";
    private static String minSpeedLimitCarTwo = "60";
    private static String maxSpeedLimitCarTwo = "120";
    private static String minSpeedLimitCarThree = "60";
    private static String maxSpeedLimitCarThree = "120";
    private static String minSpeedLimitCarFour = "60";
    private static String maxSpeedLimitCarFour = "120";


    public static int getMinSpeedLimitCarOne() {
        return Integer.parseInt(minSpeedLimitCarOne);
    }

    public static void setMinSpeedLimitCarOne(String minSpeedLimitCarOne) {
        SpeedLimit.minSpeedLimitCarOne = minSpeedLimitCarOne;
    }

    public static int getMaxSpeedLimitCarOne() {
        return Integer.parseInt(maxSpeedLimitCarOne);
    }

    public static void setMaxSpeedLimitCarOne(String maxSpeedLimitCarOne) {
        SpeedLimit.maxSpeedLimitCarOne = maxSpeedLimitCarOne;
    }

    public static int getMinSpeedLimitCarTwo() {
        return Integer.parseInt(minSpeedLimitCarTwo);
    }

    public static void setMinSpeedLimitCarTwo(String minSpeedLimitCarTwo) {
        SpeedLimit.minSpeedLimitCarTwo = minSpeedLimitCarTwo;
    }

    public static int getMaxSpeedLimitCarTwo() {
        return Integer.parseInt(maxSpeedLimitCarTwo);
    }

    public static void setMaxSpeedLimitCarTwo(String maxSpeedLimitCarTwo) {
        SpeedLimit.maxSpeedLimitCarTwo = maxSpeedLimitCarTwo;
    }

    public static int getMinSpeedLimitCarThree() {
        return Integer.parseInt(minSpeedLimitCarThree);
    }

    public static void setMinSpeedLimitCarThree(String minSpeedLimitCarThree) {
        SpeedLimit.minSpeedLimitCarThree = minSpeedLimitCarThree;
    }

    public static int getMaxSpeedLimitCarThree() {
        return Integer.parseInt(maxSpeedLimitCarThree);
    }

    public static void setMaxSpeedLimitCarThree(String maxSpeedLimitCarThree) {
        SpeedLimit.maxSpeedLimitCarThree = maxSpeedLimitCarThree;
    }

    public static int getMinSpeedLimitCarFour() {
        return Integer.parseInt(minSpeedLimitCarFour);
    }

    public static void setMinSpeedLimitCarFour(String minSpeedLimitCarFour) {
        SpeedLimit.minSpeedLimitCarFour = minSpeedLimitCarFour;
    }

    public static int getMaxSpeedLimitCarFour() {
        return Integer.parseInt(maxSpeedLimitCarFour);
    }

    public static void setMaxSpeedLimitCarFour(String maxSpeedLimitCarFour) {
        SpeedLimit.maxSpeedLimitCarFour = maxSpeedLimitCarFour;
    }


}
