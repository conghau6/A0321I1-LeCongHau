package CaseStudy.service;

import java.util.regex.Pattern;

public interface EmployeeService extends Service {
    String LEVEL = "^(trung cấp|cao đẳng|đại học)$";
    Pattern patternLevel = Pattern.compile(LEVEL);
    String VITRI = "^(lễ tân|phục vụ|chuyên viên|giám sát|quản lý|giám đốc)$";
    Pattern validateViTri = Pattern.compile(VITRI);
    int findId(int id);
}
