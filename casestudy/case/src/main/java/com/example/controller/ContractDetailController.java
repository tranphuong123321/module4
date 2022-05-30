package com.example.controller;

import com.example.model.ContractDetail;
import com.example.service.IAttachFacilityService;
import com.example.service.IContractDetailService;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContractDetailController {
    @Autowired
 private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @GetMapping(value = "/contractDetail/list/{id}")
    public String showList(@PathVariable int id, Model model, @PageableDefault(value = 2) Pageable pageable){
        model.addAttribute("contractDetailList",iContractDetailService.findAllByContract_Id(id,pageable));
        return "/contractDetail/list";
    }

    @GetMapping(value = "/contractDetail/create")
    public String create(Model model){
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("attachFacilityList",iAttachFacilityService.findAll());
        return "/contractDetail/create";
    }
}
