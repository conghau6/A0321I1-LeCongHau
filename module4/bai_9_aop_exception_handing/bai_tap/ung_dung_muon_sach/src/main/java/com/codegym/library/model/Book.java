package com.codegym.library.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "year_composed")
    @NotNull
    @Min(1)
    private String year_composed;

    @Column(name = "author")
    @NotBlank
    private String author;

    @Column(name = "quantity")
    @NotNull
    @Min(0)
    private Integer quantity;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Code> codeSet = new LinkedHashSet<>();

    public Book() {
    }

    public void generateCode(Code code){
        codeSet.add(code);
    }

    public void borrow() {
        if (quantity > 0) quantity--;
    }

    public void returnBook() {
        quantity++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear_composed() {
        return year_composed;
    }

    public void setYear_composed(String year_composed) {
        this.year_composed = year_composed;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Code> getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(Set<Code> codeSet) {
        this.codeSet = codeSet;
    }
}
