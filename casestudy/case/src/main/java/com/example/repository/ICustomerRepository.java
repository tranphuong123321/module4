package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAllByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, Integer customerType, Pageable pageable);
    Page<Customer> findAllByNameContainingAndEmailContaining(String name, String email,  Pageable pageable);


}
