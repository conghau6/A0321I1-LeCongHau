package repository;

import entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Integer id);
    void addProduct(Integer id, String name, String type, String desc, Double price, String urlImage);
    void updateProduct(Integer id, String name, String type, String desc, Double price, String urlImage);
    void deleteProduct(Integer id);
}
