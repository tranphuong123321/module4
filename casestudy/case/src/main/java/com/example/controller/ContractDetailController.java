package com.example.controller;

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
 private IContractService iContractService;
    @GetMapping(value = "/contractDetail/list/{id}")
    public String showList(@PathVariable int id, Model model){

        model.addAttribute("contract",iContractService.findById(id));
        return "/contractDetail/list";
    }
}
