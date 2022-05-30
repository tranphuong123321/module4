package com.example.service;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAllByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, String customerType, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    Customer findById(int id);
    void update(Customer customer);
    void remove(int id);
    List<Customer> findAll();
}
