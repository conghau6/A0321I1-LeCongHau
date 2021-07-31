package _11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_mang_so_nguyen;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ReverseArray a = new ReverseArray();
        System.out.println(Arrays.toString(a.reverseArrInt(new int[] {1,2,4})));
        ReverseArray b = new ReverseArray();
        System.out.println(b.reverseArrStr("Le Cong Hau"));
    }
}
