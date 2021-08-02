package _12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager listProduct = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {
            System.out.println("->MENU<-");
            System.out.println("1. Add new product");
            System.out.println("2. Show list product");
            System.out.println("3. Edit product");
            System.out.println("4. Sort product");
            System.out.println("5. Exit");
            System.out.print("Enter your choose: ");
            choice = scanner.nextInt();
            int id;
            String nameProduct;
            double price;

            int _choice = 0;
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("\tEnter -1 to exit");
                        System.out.print("\tEnter id: ");
                        id = scanner.nextInt();
                        if (id == -1) break;
                        System.out.print("\tEnter name product: ");
                        scanner.skip(scanner.nextLine());
                        nameProduct = scanner.nextLine();
                        System.out.print("\tEnter the price: ");
                        price = scanner.nextDouble();
                        listProduct.addProduct(id, nameProduct, price);
                        System.out.println();
                    }
                    break;
                case 2:
                    listProduct.showProduct();
                    break;
                case 3:
                    int index = 0;
                    do {
                        System.out.print("\tEnter id will change: ");
                        id = scanner.nextInt();
                        index = listProduct.getIndex(id);
                    } while (index < 0 || index > listProduct.size());

                    while (choice != -1) {
                        System.out.println("\t\t1. Edit ID");
                        System.out.println("\t\t2. Edit name product");
                        System.out.println("\t\t3. Edit price");
                        System.out.println("\t\t4. Exit edit");
                        System.out.print("\t\tEnter your choice: ");
                        choice = scanner.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.print("\t\tEnter new ID: ");
                                int newId = scanner.nextInt();
                                listProduct.editId(id, newId);
                                break;
                            case 2:
                                System.out.print("\t\tEnter new name product: ");
                                scanner.skip(scanner.nextLine());
                                String newName = scanner.nextLine();
                                listProduct.editName(id, newName);
                                break;
                            case 3:
                                System.out.print("\t\tEnter the new price: ");
                                double newPrice = scanner.nextDouble();
                                listProduct.editPrice(id, newPrice);
                                break;
                            case 4:
                                choice = -1;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 4:
                    _choice = 0;
                    do {
                        System.out.println("\t1. Sort Ascending");
                        System.out.println("\t2. Sort Descending");
                        System.out.print("\tEnter your choice: ");
                        _choice = scanner.nextInt();
                    } while (_choice < 1 || _choice > 2);
                    if (_choice == 1) listProduct.sortAscending();
                    else listProduct.sortDescending();
                    listProduct.showProduct();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
