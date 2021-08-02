package _12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager<E> {
    private ArrayList<Product> listProduct = new ArrayList<>();

    public void addProduct(int id, String nameProduct, double price) {
        for (Product product : listProduct) {
            if (product.getId() == id) {
                System.out.println("This ID is already exits");
                return;
            }
        }
        listProduct.add(new Product(id, nameProduct, price));
    }

    public void showProduct() {
        System.out.println("->List product: ");
        for (Product product : listProduct) {
            System.out.println("\t" + product);
        }
    }

    public int getIndex(int id) { //Tìm vị trí của id
        for (int i = 0; i < listProduct.size(); i++) {
            if (id == listProduct.get(i).getId())
                return i;
        }
        return -1;
    }

    public Product findProduct(int id) {
        int index = getIndex(id);
        return listProduct.get(index);
    }

    public void removeProduct(int id) {
        int index = getIndex(id); // TÌm vị trí index của id truyền vào
        if (index < 0 || index > listProduct.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + listProduct.size());
        }
        listProduct.remove(index);
    }

    public void editId(int id, int newId) {
        int index = getIndex(id);
        if (index < 0 || index > listProduct.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + listProduct.size());
        }
        listProduct.set(index, new Product(newId, listProduct.get(index).getNameProduct(), listProduct.get(index).getPrice()));
    }

    public void editName(int id, String newName) {
        int index = getIndex(id);
        if (index < 0 || index > listProduct.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + listProduct.size());
        }
        listProduct.set(index, new Product(id, newName, listProduct.get(index).getPrice()));
    }

    public void editPrice(int id, double newPrice) {
        int index = getIndex(id);
        if (index < 0 || index > listProduct.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + listProduct.size());
        }
        listProduct.set(index, new Product(id, listProduct.get(index).getNameProduct(), newPrice));
    }

    public int size() {
        return listProduct.size();
    }

    public void editProduct(int id) {
        Scanner scanner = new Scanner(System.in);
        int choose = 0;
        while (choose < 1 || choose > 3) {
            System.out.println("1. Edit ID");
            System.out.println("2. Edit name product");
            System.out.println("3. Edit price product");
            System.out.print("Enter the choose: ");
            choose = scanner.nextInt();
        }
        if (choose == 1) {
            System.out.print("Enter new ID: ");
            int newId = scanner.nextInt();
            editId(id, newId);
        } else if (choose == 2) {
            System.out.print("Enter new name product: ");
            scanner.skip(scanner.nextLine());
            String newName = scanner.nextLine();
            editName(id, newName);
        } else {
            System.out.println("Enter the new price: ");
            double newPrice = scanner.nextDouble();
            editPrice(id, newPrice);
        }
    }

    public void sortAscending() {
        PriceComparatorAscending priceComparatorAscending = new PriceComparatorAscending();
        Collections.sort(listProduct, priceComparatorAscending);
    }

    public void sortDescending() {
        PriceComparatorDescending priceComparatorDescending = new PriceComparatorDescending();
        Collections.sort(listProduct, priceComparatorDescending);
    }

}
