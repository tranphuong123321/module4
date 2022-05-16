package com.example.service.impl;

import com.example.model.BorrowBook;
import com.example.repository.IBorrowBookRepository;
import com.example.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookService implements IBorrowBookService {
    @Autowired
  private   IBorrowBookRepository iBorrowBookRepository;




    @Override
    public List<BorrowBook> findAll() {
        return iBorrowBookRepository.findAll();
    }

    @Override
    public void save(BorrowBook borrowBook) {
        iBorrowBookRepository.save(borrowBook);
    }

    @Override
    public BorrowBook findById(int id) {
        return iBorrowBookRepository.findById(id).orElse(null);
    }
}
