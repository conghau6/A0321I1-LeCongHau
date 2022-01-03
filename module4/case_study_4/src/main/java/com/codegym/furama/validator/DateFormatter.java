package com.codegym.furama.validator;

public class DateFormatter {
    public static String dateFormat (String date) {
        if(!date.contains("-")) return date;
        String[] str = date.split("-");
        return str[2] +"/"+ str[1] +"/"+ str[0];
    }
}
