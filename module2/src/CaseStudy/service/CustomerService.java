package CaseStudy.service;

import java.util.regex.Pattern;

public interface CustomerService extends Service {
    String LOAIKHACH = "^(diamond|platinum|gold|silver|member)$";
    Pattern patternLoaiKhach = Pattern.compile(LOAIKHACH);
    int findId(int id);
}
