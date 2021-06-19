package _1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    static double a,b,c, solution;
    static private void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        a = scanner.nextDouble();
        System.out.print("b: ");
        b = scanner.nextDouble();
        System.out.print("c: ");
        c = scanner.nextDouble();
    }
    static private void giai(){
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
    public static void main(String[] args) {
        GiaiPhuongTrinhBacNhat.nhap();
        GiaiPhuongTrinhBacNhat.giai();
    }
}
