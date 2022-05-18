package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String birthDay;
    private String idCard;
    private double salary;
    private String numberPhone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;
}
