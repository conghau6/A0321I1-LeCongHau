package _15_exception.thuc_hanh.numberformatexception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hãy nhập x: ");
        int x = scanner.nextInt();
        System.out.print("Hãy nhập y: ");
        int y = scanner.nextInt();
        CalculationExample calculationExample = new CalculationExample();
        calculationExample.calculate(x,y);
    }
}
