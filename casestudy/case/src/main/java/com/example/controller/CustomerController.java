package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import com.example.service.IFacilityTypeService;
import org.hibernate.annotations.GeneratorType;
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

import javax.validation.constraints.PastOrPresent;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;


    @GetMapping(value = "/customer/list")
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("customerList", iCustomerService.findAllByNameContaining(keywordVal, pageable));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "/customer/list";
    }

    @GetMapping(value = "customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

        return "/customer/create";
    }

    @PostMapping(value = "/customer/create")
    public String create(Customer customer, RedirectAttributes redirectAttributes) {

        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");

        return "redirect:/customer/list";
    }

    @GetMapping(value = "/customer/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "/customer/update";
    }

    @PostMapping(value = "customer/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.update(customer.getId(), customer);
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
