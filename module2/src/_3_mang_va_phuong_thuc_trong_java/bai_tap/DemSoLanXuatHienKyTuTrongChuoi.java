package _3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienKyTuTrongChuoi {
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text string: ");
        String str = scanner.nextLine();
        System.out.print("Enter a character: ");
        char c = scanner.nextLine().charAt(0);
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==c) count++;
        }
        System.out.println("Number of occurrences of character '" + c +"' is " + count);
    }
}
