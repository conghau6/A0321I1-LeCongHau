package case_study_furama_resort._models;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    public int tongNgay(String ngay) {
        int d = Integer.parseInt(String.valueOf(ngay.charAt(0))) + Integer.parseInt(String.valueOf(ngay.charAt(1)));
        int m = Integer.parseInt(String.valueOf(ngay.charAt(3))) + Integer.parseInt(String.valueOf(ngay.charAt(4)));
        int y = Integer.parseInt(String.valueOf(ngay.charAt(8))) + Integer.parseInt(String.valueOf(ngay.charAt(9)));
        return d + m*12 + y;
    }

    @Override
    public int compare(Booking o1, Booking o2) {
        if(tongNgay(o1.getNgayBatDau()) < tongNgay(o2.getNgayBatDau())) return 1;
        else if (tongNgay(o1.getNgayBatDau()) == tongNgay(o2.getNgayBatDau())) {
            if(tongNgay(o1.getNgayKetThuc()) > tongNgay(o2.getNgayKetThuc())) return 1;
            else return -1;
        }
        else return -1;
    }
}
