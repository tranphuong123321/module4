package com.example.controller;

import com.example.model.Facility;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import com.example.service.IPositionService;
import com.example.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;


    @GetMapping(value = "/facility/list")
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("facilityList", iFacilityService.findAllByNameContaining(keywordVal, pageable));
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "/facility/list";
    }

    @GetMapping(value = "/facility/create")
    public String create(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        return "/facility/create";
    }
    @PostMapping(value = "/facility/create")
    public String create(Facility facility, RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","da tao moi thanh cong");
        return "redirect:/facility/list";
    }
}
