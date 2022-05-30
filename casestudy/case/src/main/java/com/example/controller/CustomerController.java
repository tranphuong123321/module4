package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.model.CustomerType;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import com.example.service.IFacilityTypeService;
import org.hibernate.annotations.GeneratorType;
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

import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> findAllCustomerType() {
        return iCustomerTypeService.findAll();
    }

    @GetMapping(value = "/customer/list")
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable,
                           @RequestParam Optional<String> name,
                           @RequestParam Optional<String> email,
                           @RequestParam Optional<String> customerType) {

        if (name.isPresent() || email.isPresent() || customerType.isPresent()) {
            String nameVal = name.orElse("");
            String emailVal = email.orElse("");
            String customerTypeVal = customerType.orElse("");
            model.addAttribute("nameVal", nameVal);
            model.addAttribute("emailVal", emailVal);
            model.addAttribute("customerTypeVal", customerTypeVal);
            model.addAttribute("customerList", iCustomerService.findAllByNameContainingAndEmailContainingAndCustomerType_Id(nameVal, emailVal, customerTypeVal, pageable));
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "/customer/list";
        } else {
            model.addAttribute("customerList", iCustomerService.findAll(pageable));
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "/customer/list";
        }
    }

    @GetMapping(value = "customer/create")
    public String create(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping(value = "/customer/create")
    public String create(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model
    ) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
//        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/customer/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(this.iCustomerService.findById(id), customerDto);
        model.addAttribute("customerDto", customerDto);
        return "/customer/update";
    }

    @PostMapping(value = "customer/update")
    public String update(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/customer/update";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "da cap nhat thanh cong");
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/customer/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/customer/delete";
    }

    @PostMapping(value = "/customer/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {

        iCustomerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("mess", "da xoa thanh cong");
        return "redirect:/customer/list";
    }
}
