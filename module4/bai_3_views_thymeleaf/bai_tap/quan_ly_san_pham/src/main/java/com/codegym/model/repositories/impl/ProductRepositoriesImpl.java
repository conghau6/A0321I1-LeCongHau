package com.codegym.model.repositories.impl;

import com.codegym.model.bean.Product;
import com.codegym.model.repositories.ProductRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoriesImpl implements ProductRepositories {
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"iPhone 6", 2300000, "Điện thoại"));
        productList.add(new Product(2,"iPhone 7", 2300000, "Điện thoại"));
        productList.add(new Product(3,"iPhone 8", 2300000, "Điện thoại"));
        productList.add(new Product(4,"iPhone 9", 2300000, "Điện thoại"));
        productList.add(new Product(5,"iPhone 10", 2300000, "Điện thoại"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public int getIndex(int id) {
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(getIndex(id));
    }

    @Override
    public void update(Product product) {
        int index = getIndex(product.getId());
        productList.set(index,product);
    }

    @Override
    public void remove(int id) {
        productList.remove(getIndex(id));
    }
}
