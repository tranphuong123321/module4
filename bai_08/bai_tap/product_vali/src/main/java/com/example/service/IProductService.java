package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

   Page<Product> findAllByNameContaining(String name, Pageable pageable);
//    //    List<Category> findAll();
   void save(Product product);
  Product findById(int id);
    void update(int id, Product product);
   void remove(int id);
}
