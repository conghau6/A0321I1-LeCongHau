package com.codegym.library.service;

import com.codegym.library.model.Book;
import com.codegym.library.model.Code;
import com.codegym.library.repositories.BookRepositories;
import com.codegym.library.repositories.CodeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    CodeRepositories codeRepositories;

    @Autowired
    BookRepositories bookRepositories;

    @Override
    public List<Code> findAll() {
        return codeRepositories.findAll();
    }

    @Override
    public Code findById(Integer id) {
        return codeRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Code code) {
        codeRepositories.save(code);
    }

    @Override
    public void delete(Integer id) {
        Code code = codeRepositories.findById(id).orElse(null);
        Book book = bookRepositories.findById(code.getBook().getId()).orElse(null);
        book.setQuantity(book.getQuantity()-1);
        codeRepositories.deleteById(id);
        bookRepositories.save(book);
    }

    @Override
    public List<Code> findAllCodeByBookId(Integer id) {
        return codeRepositories.findCodeByBook_Id(id);
    }

    @Override
    public List<Code> findAvailableCodeByBookId(Integer id) {
        return codeRepositories.findCodeByBook_IdAndStatus_Id(id,1);
    }

    @Override
    public List<Code> findUsedCodeByBookId(Integer id) {
        return codeRepositories.findCodeByBook_IdAndStatus_Id(id,2);
    }

    @Override
    public void returnBookByCode(Book book, Integer returnCode) {

    }
}
