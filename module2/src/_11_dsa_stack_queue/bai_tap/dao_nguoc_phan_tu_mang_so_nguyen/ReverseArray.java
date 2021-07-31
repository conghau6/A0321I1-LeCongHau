package _11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_mang_so_nguyen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {
    public int[] reverseArrInt(int[] arrayInteger) {
        Stack<Integer> stacks = new Stack<>();
        for (int i = 0; i < arrayInteger.length; i++) {
            stacks.push(arrayInteger[i]);
        }
        int[] newArrayInteger = new int[arrayInteger.length];
        for (int i = 0; i < arrayInteger.length; i++) {
            newArrayInteger[i] = stacks.pop();
        }
        return newArrayInteger;
    }

    public String reverseArrStr(String myString) {
        Stack<String> stacks = new Stack<>();
        for (int i = 0; i < myString.length(); i++) {
            stacks.push(myString.charAt(i) + "");
        }
        String newMyStr = "";
        for (int i = 0; i < myString.length(); i++) {
            newMyStr += stacks.pop() + "";
        }
        return newMyStr;
    }

    public static void main(String[] args) {
        ReverseArray a = new ReverseArray();
        System.out.println(Arrays.toString(a.reverseArrInt(new int[] {1,2,4})));
        ReverseArray b = new ReverseArray();
        System.out.println(b.reverseArrStr("Le Cong Hau"));
    }
}
