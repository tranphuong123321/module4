package com.example.service;

import com.example.model.Contract;
import com.example.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);
    ContractDetail findById(int id);
}
