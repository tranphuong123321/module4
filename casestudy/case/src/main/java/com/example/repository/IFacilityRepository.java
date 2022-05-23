package com.example.repository;

import com.example.model.Customer;
import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findAllByNameContaining(String name, Pageable pageable);
}
