package com.example.service.impl;

import com.example.model.Smartphone;
import com.example.service.ISmartphoneService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartphoneService implements ISmartphoneService {


    @Override
    public Iterable<Smartphone> findAll() {
        return null;
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
