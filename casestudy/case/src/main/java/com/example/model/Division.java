package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "division")
    private List<Employee> employeeList;
}
