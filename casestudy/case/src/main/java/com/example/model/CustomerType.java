package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customerType")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeName;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;


}
