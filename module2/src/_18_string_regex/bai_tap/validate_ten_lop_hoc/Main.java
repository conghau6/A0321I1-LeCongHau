package _18_string_regex.bai_tap.validate_ten_lop_hoc;

public class Main {
    public static void main(String[] args) {
        String tenLop = "P0323A";
        KTTenLop ktTenLop = new KTTenLop();
        System.out.println(ktTenLop.check(tenLop));
    }
}
