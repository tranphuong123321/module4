package com.example.service;

import com.example.model.FacilityType;
import com.example.model.RentType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
}
