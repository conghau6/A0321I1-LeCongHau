package CaseStudy.service;

import java.util.regex.Pattern;

public interface CustomerService extends Service {
    String LOAIKHACH = "^(diamond|platinum|gold|silver|member)$";
    Pattern validateLoaiKhach = Pattern.compile(LOAIKHACH);
    int findId(int id);
}
