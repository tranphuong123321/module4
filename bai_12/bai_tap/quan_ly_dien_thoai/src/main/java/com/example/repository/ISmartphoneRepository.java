package com.example.repository;

import com.example.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository  extends JpaRepository<Smartphone,Integer> {
}
