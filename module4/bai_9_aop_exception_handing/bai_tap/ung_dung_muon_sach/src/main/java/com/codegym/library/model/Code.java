package com.codegym.library.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    @Range(min = 10000, max = 99999)
    private Integer code;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;

    public Code() {
    }

    public Code(Integer id, Integer code) {
        this.id = id;
        this.code = code;
    }

    public Code(Integer code) {
        this.code = code;
    }

    public Code(Integer code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Code(Integer code, Book book, Status status) {
        this.code = code;
        this.book = book;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
