package _2_vong_lap_trong_java.bai_tap;

public class HienThiCacSoNguyenToNhoHon100 {
    static private boolean ktNguyenTo(int x){
        for(int i=2; i<=Math.sqrt(x); i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int i=1;
        while (i<100){
            if(ktNguyenTo(i)) {
                System.out.print(i+ " ");
            }
            i++;
        }
    }
}
