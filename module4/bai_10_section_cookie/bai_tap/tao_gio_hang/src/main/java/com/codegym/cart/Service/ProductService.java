package com.codegym.cart.Service;

import com.codegym.cart.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void delete(Integer id);
    void save(Product product);
    Product findById(Integer id);
}
