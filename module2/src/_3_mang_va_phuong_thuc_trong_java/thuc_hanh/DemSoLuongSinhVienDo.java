package _3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class DemSoLuongSinhVienDo {
    public static void main(String[] args) {
        int numberStudent;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            numberStudent = scanner.nextInt();
        }while(numberStudent>30);

        int[] arr = new int[numberStudent];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            System.out.print("Enter a mark of student " + (i+1) +": ");
            arr[i] = scanner.nextInt();
            if(arr[i]>=5 && arr[i]<=10) count++;
        }
        System.out.println("The number of students passing the exam is " + count);
    }
}
