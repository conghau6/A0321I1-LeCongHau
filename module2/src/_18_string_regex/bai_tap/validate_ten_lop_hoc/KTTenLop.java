package _18_string_regex.bai_tap.validate_ten_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KTTenLop {
    public boolean check (String str) {
        String TEN_LOP = "^[C|A|P][0-9]{4}[G|H|I|K|L|M]$";
        Pattern pattern = Pattern.compile(TEN_LOP);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
