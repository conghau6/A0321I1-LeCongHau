package _10_dsa_danh_sach.bai_tap.trien_khai_phuong_thuc_cua_linkedlist;

import java.util.LinkedList;
import java.util.List;

public class TestMyLinkedList {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Hello");
        a.add(1, "Hau1");
        a.add(2, "Hau2");
        a.add(3, "Hau3");
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
