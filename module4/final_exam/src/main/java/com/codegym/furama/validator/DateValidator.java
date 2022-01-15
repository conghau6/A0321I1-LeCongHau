package com.codegym.furama.validator;

import com.codegym.furama.entity.Promotion;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DateValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Promotion.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Promotion promotion =(Promotion) target;
        String startDate = promotion.getStartDate();
        String endDate = promotion.getEndDate();

        if(!CheckDate.check(endDate,startDate)) {
            errors.rejectValue("end_date", "Nhap lon hon ngay bat dau");
        }
    }
}
