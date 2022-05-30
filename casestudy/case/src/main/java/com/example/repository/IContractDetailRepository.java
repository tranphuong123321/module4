package com.example.repository;

import com.example.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
Page<ContractDetail>  findAllByContract_Id(Integer id, Pageable pageable);


}
