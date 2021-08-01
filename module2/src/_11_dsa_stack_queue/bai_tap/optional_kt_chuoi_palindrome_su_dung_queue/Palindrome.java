package _11_dsa_stack_queue.bai_tap.optional_kt_chuoi_palindrome_su_dung_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    private String str;

    public Palindrome(String str) {
        this.str = str;
    }

    public boolean checkPalindrome() {
        Queue<String> currentStr = new LinkedList<String>();
        for(int i=0; i<str.length(); i++){
            currentStr.add(str.charAt(i)+"");
        }
        Stack<String> newStr = new Stack<>();
        for(int i=0; i<str.length(); i++){
            newStr.push(str.charAt(i)+"");
        }
        int length = currentStr.size();
        for(int i=0; i<length; i++){
            String str1 = currentStr.poll();
            String str2 = newStr.pop();
            if(!(str1.equalsIgnoreCase(str2))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome a = new Palindrome("Able was I ere I saw Elba");
        System.out.println(a.checkPalindrome());
    }
}
