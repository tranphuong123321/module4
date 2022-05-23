package com.example.controller;

import com.example.model.Contract;
import com.example.service.ICustomerService;
import com.example.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping(value = "/contract/create")
    public String create(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("facilityList",iFacilityService.findAll());
        model.addAttribute("customerList",iCustomerService.findAll());
        return "/contract/create";
    }
}
