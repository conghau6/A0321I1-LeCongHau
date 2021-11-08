package model.service.common;

import model.repositories.BenhAnRepositories;
import model.repositories.impl.BenhAnRepositoriesImpl;

public class Validator {
    static BenhAnRepositories benhAnRepositories = new BenhAnRepositoriesImpl();

    public static String validateName(String name){
        String message = null;
        String regex = "[^\\d]{1,}";
        if(!name.matches(regex)){
            message = "Tên không đúng định dạng";
        }
        return message;
    }
}
