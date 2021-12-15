package com.codegym.blog.repositories;

import com.codegym.blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category, Integer> {
}
