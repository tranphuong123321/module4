package com.example.model;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "educationDegree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;
}
