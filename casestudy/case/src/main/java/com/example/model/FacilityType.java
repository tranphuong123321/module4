package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "facilityType")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "facilityType")
    private List<Facility> facilityList;
}
