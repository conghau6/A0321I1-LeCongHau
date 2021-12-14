package com.codegym.cart.repositories;

import com.codegym.cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Product,Integer> {
}
