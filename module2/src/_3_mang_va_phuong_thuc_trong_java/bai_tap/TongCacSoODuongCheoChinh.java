package _3_mang_va_phuong_thuc_trong_java.bai_tap;

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

    }
}
