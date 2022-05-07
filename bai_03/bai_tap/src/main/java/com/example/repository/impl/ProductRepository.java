package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {

    private  static final  Map<Integer, Product> products;
    static{
        products= new LinkedHashMap<>();
        products.put(1, new Product(1, "iphone", 5000, "con hang","apple"));
        products.put(2, new Product(2, "nokia", 6000, "con hang","nokia"));
    }

    @Override
    public List<Product> findAll() {

        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
    products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return null;
    }


    @Override
    public void save(Product product) {
        product.setId(this.findAll().size()+1);
        products.put(product.getId(), product);
    }

}
