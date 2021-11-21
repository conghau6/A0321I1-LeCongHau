package com.codegym.model.bean;

import java.util.ArrayList;
import java.util.List;

public class ListPageSize {
    public static List<Integer> pageSizes(){
        List<Integer> sizes = new ArrayList<>();
        sizes.add(5);
        sizes.add(10);
        sizes.add(15);
        sizes.add(25);
        sizes.add(100);
        return sizes;
    }
}
