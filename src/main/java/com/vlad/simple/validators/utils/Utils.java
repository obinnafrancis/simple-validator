package com.vlad.simple.validators.utils;

import java.util.regex.Pattern;

public class Utils {
    public static boolean isNullOrEmpty(String s) {
        if(s==null || s.trim()==""){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isDigit(String strNum) {
        Pattern pattern = Pattern.compile("\\d+?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
