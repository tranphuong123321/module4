package com.example.service;

import com.example.model.Book;
import com.example.model.BorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> findAll();
    void save(BorrowBook borrowBook);
    BorrowBook findById(int id);

    void remove(BorrowBook borrowBook);
}
