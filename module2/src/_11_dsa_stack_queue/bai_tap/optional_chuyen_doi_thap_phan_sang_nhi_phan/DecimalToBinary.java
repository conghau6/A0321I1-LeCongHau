package _11_dsa_stack_queue.bai_tap.optional_chuyen_doi_thap_phan_sang_nhi_phan;

import java.util.Stack;

public class DecimalToBinary {
    private int decimal;

    public DecimalToBinary() {
    }

    public DecimalToBinary(int decimal) {
        this.decimal = decimal;
    }

    public String convertToBinary () {
        String stringBinary = "";
        Stack<Integer> stack = new Stack<>();
        int surPlus;
        while (decimal != 0) {
            surPlus = decimal % 2;
            stack.push(surPlus);
            decimal = decimal/2;
        }
        int size = stack.size();
        for(int i=0; i<size; i++){
            stringBinary += stack.pop();
        }
        return stringBinary;
    }
}
