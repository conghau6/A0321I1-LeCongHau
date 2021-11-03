package model.service.common;

import model.repositories.CustomerRepositories;
import model.repositories.impl.CustomerRepositoriesImpl;

public class Validator {
    static CustomerRepositories customerRepositories = new CustomerRepositoriesImpl();

    public static String validateCustomerId(String id){
        String message = null;
        String regex = "^KH-[0-9]{4}";
        if(!id.matches(regex)){
            message = "Tên không đúng định dạng";
        }
        return message;
    }
    public static String validateServiceId(String id){
        String message = null;
        String regex = "^DV-[0-9]{4}";
        if(!id.matches(regex)){
            message = "Tên không đúng định dạng";
        }
        return message;
    }
    public static String validatePhone(String phone){
        String message = null;
        String regex = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))[0-9]{7}$";
        if(!phone.matches(regex)){
            message = "Số đt không đúng định dạng";
        }
        return message;
    }
    public static String validateIdCard(String idCard){
        String message = null;
        String regex = "^([0-9]{9})|([0-9]{12})$";
        if(!idCard.matches(regex)){
            message = "Số CMND không đúng định dạng";
        }
        return message;
    }
    public static String validateEmail(String email){
        String message = null;
        String regex = "^([a-z]|[A-Z]|[0-9]){1,}\\@[a-z]{1,}\\.[a-z]{1,}$";
        if(!email.matches(regex)){
            message = "Email không đúng định dạng";
        }
        return message;
    }
    public static String validateNumber(double number){
        if(number<0) return "Không nhập số âm";
        return null;
    }
}
