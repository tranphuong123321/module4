package com.example.service.impl;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public Page<Employee> findAllByNameContaining(String name, Pageable pageable) {
        return iEmployeeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        iEmployeeRepository.delete(iEmployeeRepository.getById(id));
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}
