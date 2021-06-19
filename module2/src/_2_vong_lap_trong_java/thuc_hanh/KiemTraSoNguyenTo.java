package _2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    static int x;
    static private void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập 1 số: ");
        x = sc.nextInt();
    }
    static private boolean kiemTraNguyenTo(int x){
        for(int i=2; i<=Math.sqrt(x); i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        KiemTraSoNguyenTo.nhap();
        if(KiemTraSoNguyenTo.kiemTraNguyenTo(x))
            System.out.println(x + " là số nguyên tố ");
        else System.out.println(x + " không phải là số nguyên tố");
    }
}
