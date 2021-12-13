package com.codegym.library.service;

import com.codegym.library.model.Book;
import com.codegym.library.repositories.BookRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepositories bookRepositories;

    @Override
    public List<Book> findAll() {
        return bookRepositories.findAll();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void borrow(Book book, Integer usedCode) {

    }
}
