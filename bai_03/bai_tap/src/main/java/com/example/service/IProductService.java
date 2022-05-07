package com.example.service;

import com.example.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void delete(int id);
}
