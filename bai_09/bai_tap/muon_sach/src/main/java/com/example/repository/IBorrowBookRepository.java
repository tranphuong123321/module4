package com.example.repository;

import com.example.model.Book;
import com.example.model.BorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Integer> {

}
