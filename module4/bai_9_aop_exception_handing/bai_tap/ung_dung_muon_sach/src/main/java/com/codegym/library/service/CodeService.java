package com.codegym.library.service;

import com.codegym.library.model.Book;
import com.codegym.library.model.Code;

import java.util.List;

public interface CodeService {
    List<Code> findAll();
    Code findById(Integer id);

    void save(Code code);

    void delete(Integer id);

    List<Code> findAllCodeByBookId(Integer id);

    List<Code> findAvailableCodeByBookId(Integer id);

    List<Code> findUsedCodeByBookId(Integer id);

    void returnBookByCode(Book book, Integer returnCode);
}
