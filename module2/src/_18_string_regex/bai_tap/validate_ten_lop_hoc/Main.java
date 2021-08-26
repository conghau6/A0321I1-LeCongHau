package _18_string_regex.bai_tap.validate_ten_lop_hoc;

public class Main {
    public static void main(String[] args) {
        String nameClass = "P0323A";
        ValidateNameClass validateNameClass = new ValidateNameClass();
        System.out.println(validateNameClass.check(nameClass));
    }
}
