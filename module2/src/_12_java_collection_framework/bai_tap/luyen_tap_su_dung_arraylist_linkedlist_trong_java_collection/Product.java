package _12_java_collection_framework.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_java_collection;

public class Product implements Comparable<Product> {
    private int id;
    private String nameProduct;
    private double price;

    public Product() {
    }

    public Product(int id, String nameProduct, double price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "ID: " + id + ", Name product: " + nameProduct + ", Price: " + price;
    }

    @Override
    public int compareTo(Product o) {
        return this.getNameProduct().compareTo(o.getNameProduct());
    }
}
