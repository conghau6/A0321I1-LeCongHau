package _3_mang_va_phuong_thuc_trong_java.bai_tap;

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
        double[][] arr = {
                {1.3,43.2,7.4},
                {2.3,3.3,2.9},
                {6.3,7.3,8.9},
        };
        maxValue(arr);
    }
}
