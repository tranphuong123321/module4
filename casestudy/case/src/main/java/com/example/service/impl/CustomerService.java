package com.example.service.impl;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;




    @Override
    public Page<Customer> findAllByNameContainingAndEmailContainingAndCustomerType_Id(String name, String email, String customerType, Pageable pageable) {
        if ("".equals(customerType)){
            return this.iCustomerRepository.findAllByNameContainingAndEmailContaining(name,email,pageable);
        }else{
            return this.iCustomerRepository.findAllByNameContainingAndEmailContainingAndCustomerType_Id(name,email,Integer.parseInt(customerType),pageable);
        }
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }


    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void update( Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.delete(iCustomerRepository.getById(id));
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
