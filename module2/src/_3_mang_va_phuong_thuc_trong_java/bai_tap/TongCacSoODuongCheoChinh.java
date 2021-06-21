package _3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TongCacSoODuongCheoChinh {
    public static int sumOfDiagonalLine(int[][] array){
        int sum1 =0, sum2 = 0;
        for(int i=0; i<array.length; i++){
            sum1 += array[i][i];
            sum2 += array[i][array.length-1-i];
        }
        return sum1 + sum2;
    }
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size: ");
        size = scanner.nextInt();
        int[][] arr = new int[size][size];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print("Enter element [" + i + "," + j +"]: ");
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Sum of diagonal line: " + sumOfDiagonalLine(arr));
    }
}
