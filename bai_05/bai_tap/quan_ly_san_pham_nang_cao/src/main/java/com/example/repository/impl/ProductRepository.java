package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();

    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery(
                "select p " +
                        "from Product p " +
                        "where p.id=:idProduct", Product.class);
        typedQuery.setParameter("idProduct", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        Product product = findById(id);

        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (Product product: this.findAll()) {
            if ((product.getName().toLowerCase()).contains(name.toLowerCase())){
                productList1.add(product);
            }
        }
        return productList1;
    }
}
