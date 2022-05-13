package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    void save(Product product);
//    List<Blog> findAll();
//    void save(Blog blog);
   Product findById(int id);
    void update(int id, Product product);
   void remove(int id);
//    List<Blog> searchByName(String name);
}
