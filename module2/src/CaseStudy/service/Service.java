package CaseStudy.service;
import java.util.regex.Pattern;

public interface Service {
    String CMND = "^[0-9]{9}$";
    String EMAIL = "^[a-zA-Z][a-zA-z0-9]+\\@[a-zA-Z]+\\.([a-zA-z])+$";
    String PHONE = "^[0-9]{7,10}$";
    String BIRTHDAY = "^[0-9][0-9]{1}[/][0-9]{2}[/][0-9]{4}$";
    Pattern validateCmnd = Pattern.compile(CMND);
    Pattern validateEmail = Pattern.compile(EMAIL);
    Pattern validatePhone = Pattern.compile(PHONE);
    Pattern validateBirthDay = Pattern.compile(BIRTHDAY);
    void display();
    void edit();
    void addNew();
}
