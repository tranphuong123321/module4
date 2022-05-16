package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllByNameContaining(String name, Pageable pageable);
    void save(Book book);
    Book findById(int id);
}
