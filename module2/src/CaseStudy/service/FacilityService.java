package CaseStudy.service;

import java.util.regex.Pattern;

public interface FacilityService extends Service {
    String KIEUTHUE = "^(năm|tháng|ngày|giờ)$";
    Pattern patternKieuThue = Pattern.compile(KIEUTHUE);
    void displayFacilityMaintenance();
}
