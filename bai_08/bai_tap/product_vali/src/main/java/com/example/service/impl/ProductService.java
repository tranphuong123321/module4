package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
  private   IProductRepository iProductRepository;
    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.delete(iProductRepository.getById(id));
    }
}
