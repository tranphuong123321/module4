package com.example.controller;

import com.example.model.Employee;
import com.example.service.IDivisionService;
import com.example.service.IEducationDegreeService;
import com.example.service.IEmployeeService;
import com.example.service.IPositionService;
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
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @GetMapping(value = "/employee/list")
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("employeeList", iEmployeeService.findAllByNameContaining(keywordVal, pageable));
        return "/employee/list";
    }

    @GetMapping(value = "/employee/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationList", iEducationDegreeService.findAll());

        return "/employee/create";
    }

    @PostMapping(value = "/employee/create")
    public String create(Employee employee, RedirectAttributes redirectAttributes) {

        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/employee/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", iEmployeeService.findById(id));
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationList", iEducationDegreeService.findAll());

        return "/employee/update";
    }

    @PostMapping(value = "/employee/update")
    public String update(Employee employee,RedirectAttributes redirectAttributes) {
        iEmployeeService.update(employee.getId(),employee);
        redirectAttributes.addFlashAttribute("mess","da cap nhat thanh cong");

        return "redirect:/employee/list";
    }
    @GetMapping(value = "/employee/delete/{id}")
    public String delete(@PathVariable int id, Model model){

        model.addAttribute("employee",iEmployeeService.findById(id));
        return "/employee/delete";
    }
    @PostMapping(value = "/employee/delete")
    public String delete( Employee employee,RedirectAttributes redirectAttributes){

        iEmployeeService.remove(employee.getId());
        redirectAttributes.addFlashAttribute("mess","da xoa thanh cong");
        return "redirect:/employee/list";
    }
}
