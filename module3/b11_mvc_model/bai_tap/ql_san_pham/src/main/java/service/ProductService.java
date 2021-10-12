package service;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void addProduct(Integer id, String name, String type, String desc, Double price, String urlImage) throws Exception;
    void updateProduct(Integer id, String name, String type, String desc, Double price, String urlImage) throws Exception;
    void deleteProduct(Integer id);
}
