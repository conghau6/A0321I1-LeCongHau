package FinalExam.utils;

public class CheckNgay {
    public static int tongNgay(String ngay) {
        int d = Integer.parseInt(String.valueOf(ngay.charAt(0))) + Integer.parseInt(String.valueOf(ngay.charAt(1)));
        int m = Integer.parseInt(String.valueOf(ngay.charAt(3))) + Integer.parseInt(String.valueOf(ngay.charAt(4)));
        int y = Integer.parseInt(String.valueOf(ngay.charAt(8))) + Integer.parseInt(String.valueOf(ngay.charAt(9)));
        return d + m*12 + y*4;
    }
}
