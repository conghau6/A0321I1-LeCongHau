package com.codegym.furama.validator;

import java.time.LocalDate;
import java.time.Period;

public class CheckDate {
    public static Boolean check (String date1, String date2) {
        String[] str1 = date1.split("-");
        String[] str2 = date2.split("-");
        LocalDate startDate = LocalDate.of(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]), Integer.parseInt(str1[2]));

        LocalDate endDate = LocalDate.of(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]), Integer.parseInt(str2[2]));
        Period different = Period.between(endDate, startDate);

        if(different.getYears()>0 || different.getMonths()>0 || different.getDays()>0) return false;

        return true;
    }
}
