package com.oshop.common.utils;

public class NumberUtils {

    public static boolean isInt(Double num){
        return num.intValue() == num;
    }

    public static boolean isDigit(String str){
        if (null == str || str.trim().equals("")){
            return false;
        }
        return  str.matches("^\\d+$");
    }
}
