package com.codegym.validate_login.validator;

import com.codegym.validate_login.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        if(!user.getName().matches("^\\D+$")){
            errors.rejectValue("name","name.matches");
        }
        if(!user.getPhone().startsWith("0")){
            errors.rejectValue("phone","phone.startWith");
        }
        if(user.getPhone().length()>11 || user.getPhone().length()<10){
            errors.rejectValue("phone","phone.length");
        }
        if(!user.getPhone().matches("^\\d+$")){
            errors.rejectValue("phone","phone.matches");
        }
    }
}
