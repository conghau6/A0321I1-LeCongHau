package CaseStudy.service;

import java.util.regex.Pattern;

public interface EmployeeService extends Service {
    String TRINHDO = "^(trung cấp|cao đẳng|đại học)$";
    Pattern validateTrinhDo = Pattern.compile(TRINHDO);
    String VITRI = "^(lễ tân|phục vụ|chuyên viên|giám sát|quản lý|giám đốc)$";
    Pattern validateViTri = Pattern.compile(VITRI);
    int findId(int id);
}
