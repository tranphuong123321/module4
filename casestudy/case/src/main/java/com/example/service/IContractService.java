package com.example.service;

import com.example.model.Contract;
import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<Contract> findAll( Pageable pageable);
    void save(Contract contract);
    Contract findById(int id);
}
