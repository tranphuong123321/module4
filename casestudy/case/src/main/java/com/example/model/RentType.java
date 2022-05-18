package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rentType")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;

    @OneToMany(mappedBy = "rentType")
    private List<Facility> facilityList;
}
