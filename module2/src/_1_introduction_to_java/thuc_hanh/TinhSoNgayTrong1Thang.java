package _1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class TinhSoNgayTrong1Thang {
    public static void main(String[] args) {
        String dayInMonth;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which month that you want to count days:  ");
        int month = scanner.nextInt();
        switch (month){
            case 2:
                dayInMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayInMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayInMonth = "30";
                break;
            default:
                dayInMonth = "";
        }
        System.out.println("The month " + month + " has " +dayInMonth);
    }

}
