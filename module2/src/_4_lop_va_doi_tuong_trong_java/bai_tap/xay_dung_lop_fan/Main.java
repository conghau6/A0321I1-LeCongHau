package _4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_fan;

public class Main {
    public static void main(String[] args) {
        Fan Fan1 = new Fan(Fan.FAST, 10, "yellow", true);
        Fan Fan2 = new Fan(Fan.MEDIUM, 5, "blue", false);
        System.out.println(Fan1);
        System.out.println(Fan2);
    }
}
