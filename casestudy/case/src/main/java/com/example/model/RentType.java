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

    public RentType() {
    }

    public RentType(int id, String name, double cost, List<Facility> facilityList) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.facilityList = facilityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
