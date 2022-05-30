package com.example.repository;

import com.example.model.Customer;
import com.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {


    Page<Employee> findAllByNameContainingAndEmailContainingAndPosition_Id(String name, String email, Integer position, Pageable pageable);
    Page<Employee> findAllByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

//    @Query(value = "select * from employee where name like :name and email like :email and position_id like :positon",
//    countQuery =  "select * from employee where name like :name and email like :email and position_id like :positon",
//    nativeQuery = true)
//    Page<Employee> findAllByKeyword(String name, String email, String position, Pageable pageable);

}

