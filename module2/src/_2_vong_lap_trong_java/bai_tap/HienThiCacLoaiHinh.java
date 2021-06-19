package _2_vong_lap_trong_java.bai_tap;


import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice=-1;
        while (choice!=4){
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    for(int i=0; i<3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("1. Top-left");
                    System.out.println("2. Top-right");
                    System.out.println("3. Botton-left");
                    System.out.println("4. Botton-right");
                    System.out.print("Enter your choice: ");
                    int choiceTriangle = scanner.nextInt();
                    switch (choiceTriangle){
                        case 1:
                            for (int i=5; i>=1; i--){
                                for (int j=1; j<=i; j++){
                                    System.out.print(" * ");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            for (int i=0; i<5; i++){
                                for (int j=1; j<=i; j++){
                                    System.out.print("   ");
                                }
                                for (int j=1; j<=5-i; j++){
                                    System.out.print(" * ");
                                }
                                System.out.println();
                            }
                            break;
                        case 3:
                            for (int i=1; i<=5; i++){
                                for(int j=1; j<=i; j++){
                                    System.out.print(" * ");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            for(int i=1; i<=5; i++){
                                for(int j=1; j<=5-i; j++){
                                    System.out.print("   ");
                                }
                                for(int j=1; j<= i; j++){
                                    System.out.print(" * ");
                                }
                                System.out.println();
                            }
                            break;
                    }
                    break;
                case 3:
                    for(int i=1; i<=5; i++){
                        for (int j=i; j<=5-1; j++){
                            System.out.print("   ");
                        }
                        for (int j=1; j<=2*i-1; j++){
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
