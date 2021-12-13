package com.codegym.library.controller;

import com.codegym.library.model.Book;
import com.codegym.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public String listBook(Model model){
        model.addAttribute("listBook",bookService.findAll());
        return "index";
    }

    @GetMapping("/book/create")
    public String getBook(Model model){
        model.addAttribute("book", new Book());
        return "book/create";
    }
}
