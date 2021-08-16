package case_study_furama_resort._services;

import case_study_furama_resort._models.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl {
    private static ArrayList<Employee> listEmployee;

    static {
        listEmployee = new ArrayList<>();
    }

    public static void displayListEmployee() {
        for (Employee employee : listEmployee) {
            System.out.println(employee);
        }
    }

    public static void addNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        String id = scanner.next();
        System.out.print("Enter name employee: ");
        scanner.skip("\\R");
        String name = scanner.nextLine();
        System.out.print("Enter age employee: ");
        int age = scanner.nextInt();
        System.out.print("Enter salary of employee: ");
        double salary = scanner.nextDouble();
        listEmployee.add(new Employee(id, name, age, salary));
    }

    public static int findId(String id) throws Exception{
        for (int i = 0; i < listEmployee.size(); i++) {
            if (listEmployee.get(i).getId().equals(id)) {
                return i;
            }
        }
        throw new Exception("Error");
    }

    public static void editEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id of Employee: ");
        String id = scanner.next();

        try {
            int index = findId(id);
            System.out.println("1. Edit name" +
                    "\n2. Edit age" +
                    "\n3. Edit salary");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    scanner.skip("\\R");
                    String newName = scanner.nextLine();
                    listEmployee.get(index).setName(newName);
                    break;
                case 2:
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    listEmployee.get(index).setAge(newAge);
                    break;
                case 3:
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    listEmployee.get(index).setSalary(newSalary);
                    break;
                default:
                    break;
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        EmployeeServiceImpl.addNewEmployee();
        EmployeeServiceImpl.editEmployee();
        EmployeeServiceImpl.displayListEmployee();
    }
}
