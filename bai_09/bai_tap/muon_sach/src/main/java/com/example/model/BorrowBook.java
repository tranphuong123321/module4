package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="borrowBook")
public class BorrowBook {
    @Id
    private Integer idBorrow;


    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public BorrowBook() {
    }

    public BorrowBook(Integer idBorrow, Book book) {
        this.idBorrow = idBorrow;
        this.book = book;
    }

    public Integer getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(Integer idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
