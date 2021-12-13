package com.codegym.library.service;

import com.codegym.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void save(Book book);
    void delete(Integer id);
    void borrow(Book book, Integer usedCode);
}
