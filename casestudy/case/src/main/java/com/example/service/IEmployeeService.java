package com.example.service;


import com.example.model.Customer;
import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllByNameContainingAndEmailContainingAndPosition_Id(String name, String email, String position, Pageable pageable);
    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
   Employee findById(int id);
   void update(Employee employee);
  void remove(int id);
    List<Employee> findAll();

}
