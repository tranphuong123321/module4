package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String birthday;
    private String gender;
    private String idCard;
    private String  numberPhone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy ="customer")
    private List<Contract> contractList;



}
