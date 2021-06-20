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
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size: ");
        size = scanner.nextInt();
        double[][] arr = new double[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print("Enter element arr[" + i + "," + j + "]");
                arr[i][j] = scanner.nextDouble();
            }
        }
        maxValue(arr);
    }
}
