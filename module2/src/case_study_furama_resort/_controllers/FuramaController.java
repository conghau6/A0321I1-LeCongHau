package case_study_furama_resort._controllers;

import case_study_furama_resort._services.CustomerServiceImpl;
import case_study_furama_resort._services.EmployeeServiceImpl;
import case_study_furama_resort._services.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    FacilityServiceImpl facilityService = new FacilityServiceImpl();

    public void displayMainMenu() {
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit Management");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1. Display list employees");
                System.out.println("2. Add new employee");
                System.out.println("3. Edit employee");
                System.out.println("4. Return QLSanPham menu");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: employeeService.hienThi(); break;
                    case 2: employeeService.themMoi(); break;
                    case 3: employeeService.sua(); break;
                    case 4: break;
                    default: break;
                }
                break;
            case 2:
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Return QLSanPham menu");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: customerService.hienThi(); break;
                    case 2: customerService.themMoi(); break;
                    case 3: customerService.sua(); break;
                    case 4: break;
                    default: break;
                }
                break;
            case 3:
                System.out.println("1. Display list facility");
                System.out.println("2. Add new facility");
                System.out.println("3. Display list facility maintenance");
                System.out.println("4. Return QLSanPham menu");
                choice= scanner.nextInt();
                switch (choice) {
                    case 1: facilityService.hienThi(); break;
                    case 2: facilityService.themMoi(); break;
                    case 3: facilityService.hienThiFacilityCanBaoTri(); break;
                }
                break;
            case 4:
                System.out.println("1. Add new booking");
                System.out.println("2. Display list booking");
                System.out.println("3. Create new contracts");
                System.out.println("4. Display list contracts");
                System.out.println("5. Edit contracts");
                System.out.println("6. Return QLSanPham menu");
                break;
            case 5:
                System.out.println("1. Display list customer use service");
                System.out.println("2. Display list customer get voucher");
                System.out.println("3. Return QLSanPham menu");
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        while (true) {
            furamaController.displayMainMenu();
        }
    }
}
