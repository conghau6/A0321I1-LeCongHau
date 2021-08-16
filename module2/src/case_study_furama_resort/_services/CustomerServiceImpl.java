package case_study_furama_resort._services;

import case_study_furama_resort._models.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl {
    private static ArrayList<Customer> listCustomer;

    static {
        listCustomer = new ArrayList<>();
    }

    public static void displayListCustomer() {
        for (Customer customer : listCustomer) {
            System.out.println(customer);
        }
    }

    public static void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        String id = scanner.next();
        System.out.print("Enter name customer: ");
        scanner.skip("\\R");
        String name = scanner.nextLine();
        System.out.print("Enter age customer: ");
        int age = scanner.nextInt();
        System.out.print("Enter salary of customer: ");
        double balance = scanner.nextDouble();
        listCustomer.add(new Customer(id, name, age, balance));
    }

    public static int findId(String id) throws Exception{
        for (int i = 0; i < listCustomer.size(); i++) {
            if (listCustomer.get(i).getId().equals(id)) {
                return i;
            }
        }
        throw new Exception("Error");
    }

    public static void editCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id of Customer: ");
        String id = scanner.next();

        try {
            int index = findId(id);
            System.out.println("1. Edit name" +
                    "\n2. Edit age" +
                    "\n3. Edit balance");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    scanner.skip("\\R");
                    String newName = scanner.nextLine();
                    listCustomer.get(index).setName(newName);
                    break;
                case 2:
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    listCustomer.get(index).setAge(newAge);
                    break;
                case 3:
                    System.out.print("Enter new balance: ");
                    double newBalance = scanner.nextDouble();
                    listCustomer.get(index).setBalance(newBalance);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        CustomerServiceImpl.addNewCustomer();
        CustomerServiceImpl.editCustomer();
        CustomerServiceImpl.displayListCustomer();
    }
}
