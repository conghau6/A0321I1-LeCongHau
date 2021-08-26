package _18_string_regex.bai_tap.validate_ten_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClass {
    public boolean check (String nameClass) {
        String NAME_CLASS = "^[C|A|P][0-9]{4}[G|H|I|K|L|M]$";
        Pattern pattern = Pattern.compile(NAME_CLASS);
        Matcher matcher = pattern.matcher(nameClass);
        return matcher.matches();
    }

}
