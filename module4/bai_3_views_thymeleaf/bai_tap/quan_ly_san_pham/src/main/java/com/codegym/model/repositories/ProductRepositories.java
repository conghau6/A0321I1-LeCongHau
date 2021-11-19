package com.codegym.model.repositories;

import com.codegym.model.bean.Product;

import java.util.List;

public interface ProductRepositories {
    List<Product> findAll();

    int getIndex(int id);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);
}
