package _3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class ChuongTrinhChuyenDoiNhietDo {
    public static double celsiusToFahrenheit(double celsius){
        return (9.0/5) * celsius + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit){
        return (5.0/9) * (fahrenheit - 32);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double celsius, fahrenheit;
        do{
            System.out.println("Menu: ");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    System.out.println("Fahrenheit to celsius :" + fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.print("Enter Celsius: ");
                    celsius = scanner.nextDouble();
                    System.out.println("Celsius to fahrenheit :" + fahrenheitToCelsius(celsius));
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not choice");
            }
        }while (choice!=0);
    }
}
