package _3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuCuaMang {
    public static int[] delete(int value, int[] array){
        int index = -1;
        for(int i=0; i<array.length; i++){
            if(array[i]==value) index = i;
        }
        if(index!=-1){
            for(int i=index; i<array.length-1; i++){
                array[i] = array[i+1];
            }
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1,2,5,7,8,23};
        delete(7, arr);
        System.out.println("New array: " + Arrays.toString(arr));
    }
}
