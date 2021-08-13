package _15_exception.thuc_hanh.illegaltriangleexception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter size 1: ");
            int size1 = scanner.nextInt();
            System.out.println("Enter size 2: ");
            int size2 = scanner.nextInt();
            System.out.println("Enter size 3: ");
            int size3 = scanner.nextInt();
            Triangle triangle = new Triangle(size1, size2, size3);
        } catch (TamGiacException e){
            e.printStackTrace();
        }
    }
}
