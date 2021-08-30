package CaseStudy.service;
import java.util.regex.Pattern;

public interface Service {
    String CMND = "^[0-9]{9}$";
    String EMAIL = "^[a-zA-Z][a-zA-z0-9]+\\@[a-zA-Z]+\\.([a-zA-z])+$";
    String PHONE = "^[0-9]{7,10}$";
    String BIRTHDAY = "^[0-9][0-9]{1}[/][0-9]{2}[/][0-9]{4}$";
    Pattern patternCmnd = Pattern.compile(CMND);
    Pattern patternEmail = Pattern.compile(EMAIL);
    Pattern patternPhone = Pattern.compile(PHONE);
    Pattern patternBirthday = Pattern.compile(BIRTHDAY);
    void display();
    void edit();
    void addNew();
}
