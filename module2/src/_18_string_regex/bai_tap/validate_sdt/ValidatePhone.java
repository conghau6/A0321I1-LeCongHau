package _18_string_regex.bai_tap.validate_sdt;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    public boolean check(String phone) {
        String PHONE = "^\\([0-9]{2}\\)\\-\\([0-9]*\\)$";
        Pattern pattern = Pattern.compile(PHONE);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
