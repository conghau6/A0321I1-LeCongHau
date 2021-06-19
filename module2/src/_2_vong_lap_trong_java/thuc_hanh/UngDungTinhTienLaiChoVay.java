package _2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class UngDungTinhTienLaiChoVay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền gữi: ");
        double so_tien_gui = scanner.nextDouble();
        System.out.print("Nhập tỉ lệ lãi suất (%/năm): ");
        double ti_le_lai_suat = scanner.nextDouble();
        System.out.print("Nhập số tháng gũi: ");
        int so_thang_gui = scanner.nextInt();
        double so_tien_lai = 0;
        for(int i=0; i < so_thang_gui; i++) {
            so_tien_lai += so_tien_gui * (ti_le_lai_suat/100)/12 * so_thang_gui;
        }
        System.out.println("Số tiền lãi = " + so_tien_lai);
    }
}
