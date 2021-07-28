package _11_dsa_stack_queue.bai_tap.dao_nguoc_phan_tu_mang_so_nguyen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {
    private int[] arrayInteger;
    private String myString;

    public ReverseArray() {
    }

    public ReverseArray(int[] arrayInteger) {
        this.arrayInteger = arrayInteger;
    }

    public ReverseArray(String myString) {
        this.myString = myString;
    }

    public int[] reverseArrInt() {
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

    public String reverseArrStr() {
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
        ReverseArray intArray = new ReverseArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(intArray.reverseArrInt()));
        ReverseArray strArray = new ReverseArray("leconghau");
        System.out.println(strArray.reverseArrStr());
    }
}
