package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attachFacility")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;
    private int unit;
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    private List<ContractDetail> contractDetailList;
}
