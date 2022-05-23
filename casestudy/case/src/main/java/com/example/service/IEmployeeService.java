package com.example.service;


import com.example.model.Customer;
import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
    void save(Employee employee);
   Employee findById(int id);
   void update(int id, Employee employee);
  void remove(int id);
}