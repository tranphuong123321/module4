package com.example.service;

import com.example.model.Customer;
import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAllByNameContaining(String name, Pageable pageable);
    void save(Facility facility);
    List<Facility> findAll();
}
