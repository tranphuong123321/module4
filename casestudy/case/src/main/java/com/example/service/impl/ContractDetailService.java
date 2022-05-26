package com.example.service.impl;

import com.example.model.ContractDetail;
import com.example.repository.IContractDetailRepository;
import com.example.repository.IContractRepository;
import com.example.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public ContractDetail findById(int id) {
        return iContractDetailRepository.findById(id).orElse(null);
    }
}
