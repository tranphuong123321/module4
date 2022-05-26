package com.example.controller;

import com.example.model.Contract;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ContractController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IContractDetailService iContractDetailService;


    @GetMapping(value = "/contract/list")
    public String showList(Model model, @PageableDefault(2)Pageable pageable){

        model.addAttribute("contractList",iContractService.findAll(pageable));
        return "/contract/list";
    }

    @GetMapping(value = "/contract/create")
    public String create(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("facilityList",iFacilityService.findAll());
        model.addAttribute("customerList",iCustomerService.findAll());
        model.addAttribute("employeeList",iEmployeeService.findAll());

        return "/contract/create";
    }
    @PostMapping(value = "/contract/create")
    public String create(Contract contract, RedirectAttributes redirectAttributes){

iContractService.save(contract);
redirectAttributes.addFlashAttribute("mess","da tao moi thanh cong");
        return "redirect:/contract/list";
    }

}
