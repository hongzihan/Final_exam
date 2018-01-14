package com.example.hu.finalexam.domain;

/**
 * Created by ken on 2018/1/15.
 */

public class IndexLimit {


    private static String minTemLimit="10";
    private static String maxTemLimit="40";
    private static String minHumLimit="50";
    private static String maxHumLimit="150";
    private static String minPmLimit="500";
    private static String maxPmLimit="5000";
    private static String minCoLimit="100";
    private static String maxCoLimit="600";
    private static String minSunLimit="0";
    private static String maxSunLimit="100";
    private static String minRoadLimit="1";
    private static String maxRoadLimit="5";




    public static int getMinTemLimit() {
        return Integer.parseInt(minTemLimit);
    }

    public static void setMinTemLimit(String minTemLimit) {
        IndexLimit.minTemLimit = minTemLimit;
    }

    public static int getMaxTemLimit() {
        return Integer.parseInt(maxTemLimit);
    }

    public static void setMaxTemLimit(String maxTemLimit) {
        IndexLimit.maxTemLimit = maxTemLimit;
    }

    public static int getMinHumLimit() {
        return Integer.parseInt(minHumLimit);
    }

    public static void setMinHumLimit(String minHumLimit) {
        IndexLimit.minHumLimit = minHumLimit;
    }

    public static int getMaxHumLimit() {
        return Integer.parseInt(maxHumLimit);
    }

    public static void setMaxHumLimit(String maxHumLimit) {
        IndexLimit.maxHumLimit = maxHumLimit;
    }

    public static int getMinPmLimit() {
        return Integer.parseInt(minPmLimit);
    }

    public static void setMinPmLimit(String minPmLimit) {
        IndexLimit.minPmLimit = minPmLimit;
    }

    public static int getMaxPmLimit() {
        return Integer.parseInt(maxPmLimit);
    }

    public static void setMaxPmLimit(String maxPmLimit) {
        IndexLimit.maxPmLimit = maxPmLimit;
    }

    public static int getMinCoLimit() {
        return Integer.parseInt(minCoLimit);
    }

    public static void setMinCoLimit(String minCoLimit) {
        IndexLimit.minCoLimit = minCoLimit;
    }

    public static int getMaxCoLimit() {
        return Integer.parseInt(maxCoLimit);
    }

    public static void setMaxCoLimit(String maxCoLimit) {
        IndexLimit.maxCoLimit = maxCoLimit;
    }

    public static int getMinSunLimit() {
        return Integer.parseInt(minSunLimit);
    }

    public static void setMinSunLimit(String minSunLimit) {
        IndexLimit.minSunLimit = minSunLimit;
    }

    public static int getMaxSunLimit() {
        return Integer.parseInt(maxSunLimit);
    }

    public static void setMaxSunLimit(String maxSunLimit) {
        IndexLimit.maxSunLimit = maxSunLimit;
    }

    public static int getMinRoadLimit() {
        return Integer.parseInt(minRoadLimit);
    }

    public static void setMinRoadLimit(String minRoadLimit) {
        IndexLimit.minRoadLimit = minRoadLimit;
    }

    public static int getMaxRoadLimit() {
        return Integer.parseInt(maxRoadLimit);
    }

    public static void setMaxRoadLimit(String maxRoadLimit) {
        IndexLimit.maxRoadLimit = maxRoadLimit;
    }






}
