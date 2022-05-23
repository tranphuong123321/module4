package com.example.service;

import com.example.model.CustomerType;
import com.example.model.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
