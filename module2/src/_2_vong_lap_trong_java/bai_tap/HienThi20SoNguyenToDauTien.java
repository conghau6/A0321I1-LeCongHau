package _2_vong_lap_trong_java.bai_tap;

public class HienThi20SoNguyenToDauTien {
    static private boolean ktNguyenTo(int x){
        for(int i=2; i<=Math.sqrt(x); i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int i=1;
        int dem=0;
        while (dem<=20){
            if(ktNguyenTo(i)){
                dem++;
                System.out.print(i + " ");
            }
            i++;
        }
    }
}
