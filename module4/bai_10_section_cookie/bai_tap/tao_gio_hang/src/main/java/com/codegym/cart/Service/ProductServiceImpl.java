package com.codegym.cart.Service;

import com.codegym.cart.model.Product;
import com.codegym.cart.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepositories productRepositories;

    @Override
    public List<Product> findAll() {
        return productRepositories.findAll();
    }

    @Override
    public void delete(Integer id) {
        productRepositories.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepositories.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepositories.findById(id).orElse(null);
    }
}
