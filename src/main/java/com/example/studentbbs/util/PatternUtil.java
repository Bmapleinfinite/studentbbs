package com.example.studentbbs.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {
    public static boolean isEmail(String emailStr) {
        String check = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(check, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailStr);
        return matcher.find();
    }
    // public static void main(String[] args) {
    //     System.out.println(isEmail("rgbugegjcmu@163.com"));
    // }
}
