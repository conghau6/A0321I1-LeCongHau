package _3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TImPhanTuLonNhatTrongMang2Chieu {
    public static void maxValue(double[][] array){
        double max = array[0][0];
        int x=0,y=0;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++) {
                if(array[i][j]>max){
                    max = array[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("Max value is " + max + " at position array["
                +x+","+y+"]");
    }
    public static void main(String[] args) {
        int row, column;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a row: ");
        row = scanner.nextInt();
        System.out.print("Enter a column: ");
        column = scanner.nextInt();
        double[][] arr = new double[row][column];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print("Enter element arr[" + i + "," + j + "]");
                arr[i][j] = scanner.nextDouble();
            }
        }
        maxValue(arr);
    }
}
