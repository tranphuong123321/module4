package com.example.repository;

import com.example.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {


}
