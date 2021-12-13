package com.codegym.library.service;

import com.codegym.library.model.Book;
import com.codegym.library.model.Code;
import com.codegym.library.model.Status;
import com.codegym.library.repositories.BookRepositories;
import com.codegym.library.repositories.CodeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepositories bookRepositories;

    @Autowired
    CodeService codeService;

    @Override
    public List<Book> findAll() {
        return bookRepositories.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepositories.save(book);
        Status available = new Status(1);
        for(int i=0; i<book.getQuantity(); i++){
            int n =10000 + new Random().nextInt(90000);
            Code code = new Code(n,bookRepositories.findById(book.getId()).orElse(null),available);
            book.generateCode(code);
            codeService.save(code);
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void borrow(Book book, Integer usedCode) {
        List<Code>codeList = codeService.findAllCodeByBookId(book.getId());
        for(Code code : codeList){
            if(code.getCode().equals(usedCode)){
                code.setStatus(new Status(2,"used"));
                break;
            }
        }
        book.borrow();
        bookRepositories.save(book);
    }

    @Override
    public void returnBook(Book book, Integer returnCode) {
        List<Code> codeList = codeService.findUsedCodeByBookId(book.getId());
        for(Code code : codeList){
            if(code.getCode().equals(returnCode)){
                code.setStatus(new Status(1,"available"));
                codeService.save(code);
                book.returnBook();
                bookRepositories.save(book);
                break;
            }
        }
    }

    @Override
    public Book findById(Integer id) {
        return bookRepositories.findById(id).orElse(null);
    }

    @Override
    public Code getNextAvailableCode(Book book) {
        List<Code> codeList = codeService.findAllCodeByBookId(book.getId());
        for(Code code : codeList){
            if(code.getStatus().getId() == 1){
                return code;
            }
        }
        return null;
    }
}
