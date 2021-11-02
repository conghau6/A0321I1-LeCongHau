package model.service.common;

import model.repositories.CustomerRepositories;
import model.repositories.impl.CustomerRepositoriesImpl;

public class Validator {
    static CustomerRepositories customerRepositories = new CustomerRepositoriesImpl();

    public static String validateCustomerName(String name){
        String message = null;
        String regex = "^KH-[0-9]{4}";
        if(!name.matches()){
            message
        }
    }
}
