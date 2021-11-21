package com.codegym.model.bean;

import java.util.ArrayList;
import java.util.List;

public class ListLanguages {
    public static List<String> languages(){
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }
}
