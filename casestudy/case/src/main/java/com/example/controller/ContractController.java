package com.example.controller;

import com.example.dto.ContractDto;
import com.example.dto.CustomerDto;
import com.example.model.Contract;
import com.example.model.Customer;
import com.example.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    public String showList(Model model, @PageableDefault(value = 2)Pageable pageable){
        model.addAttribute("contractList",iContractService.findAll(pageable));
        model.addAttribute("facilityList",iFacilityService.findAll());
        model.addAttribute("customerList",iCustomerService.findAll());
        model.addAttribute("employeeList",iEmployeeService.findAll());
        return "contract/list";
    }

    @GetMapping(value = "/contract/create")
    public String create(Model model){
        model.addAttribute("contractDto",new ContractDto());
        model.addAttribute("facilityList",iFacilityService.findAll());
        model.addAttribute("customerList",iCustomerService.findAll());
        model.addAttribute("employeeList",iEmployeeService.findAll());

        return "/contract/create";
    }
    @PostMapping(value = "/contract/create")
    public String create(@ModelAttribute @Validated ContractDto contractDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
//       new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityList",iFacilityService.findAll());
            model.addAttribute("customerList",iCustomerService.findAll());
            model.addAttribute("employeeList",iEmployeeService.findAll());
//            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "/contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.iContractService.save(contract);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/contract/list";
    }

}
