package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void save(Blog blog);
    void remove(Integer id);
    void remove(Blog blog);
    Page<Blog> searchByTitle(String c, Pageable p);
    List<Blog> searchByTitle(String c);
    Page<Blog> findBlogByCategory_Id(Integer id, Pageable p);
    List<Blog> findAllByCategory_Id(Integer id);
}
