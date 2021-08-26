package _18_string_regex.bai_tap.validate_sdt;

public class Main {
    public static void main(String[] args) {
        ValidatePhone validatePhone = new ValidatePhone();
        String phone = "(84)-(0978489648)";
        System.out.println(validatePhone.check(phone));
    }
}
