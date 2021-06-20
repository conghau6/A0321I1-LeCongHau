package _3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;

public class GopMang {
    public static int[] mergeArray(int[] array1, int[] array2){
        int[] newArray = new int[array1.length + array2.length];
        for(int i=0; i<array1.length; i++){
            newArray[i] = array1[i];
        }
        int x = 0;
        for(int i=array1.length; i<newArray.length; i++){
                newArray[i] = array2[x];
                x++;
            }
        return newArray;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,5,7,8,23};
        int[] arr2 = {9,6,78,32,4,53};
        int[] newArray = mergeArray(arr1, arr2);
        System.out.println(Arrays.toString(newArray));
    }
}
