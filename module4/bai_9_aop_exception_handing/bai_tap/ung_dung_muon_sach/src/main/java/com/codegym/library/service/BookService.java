package com.codegym.library.service;

import com.codegym.library.model.Book;
import com.codegym.library.model.Code;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void save(Book book);
    void delete(Integer id);
    void borrow(Book book, Integer usedCode);
    void returnBook(Book book, Integer returnCode);
    Book findById(Integer id);
    Code getNextAvailableCode(Book book);
}
