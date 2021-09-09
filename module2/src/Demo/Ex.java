package Demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            boolean nhapSai = false;
            System.out.print("Nhập vào 1 số: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, hãy nhập lại");
                nhapSai = true;
            }

           if(!nhapSai) {
               System.out.println("Số bạn đã nhập: " + choice);
           }
        }
    }
}
