package com.codegym.model.bean;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private String desc;

    public Product(int id, String nameProduct, double price, String desc) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
