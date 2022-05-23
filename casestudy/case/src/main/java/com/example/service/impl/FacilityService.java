package com.example.service.impl;

import com.example.model.Facility;
import com.example.repository.IFacilityRepository;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public Page<Facility> findAllByNameContaining(String name, Pageable pageable) {
        return iFacilityRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }
}
