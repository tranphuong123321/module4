package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.EmployeeDto;
import com.example.model.Customer;
import com.example.model.Employee;
import com.example.service.IDivisionService;
import com.example.service.IEducationDegreeService;
import com.example.service.IEmployeeService;
import com.example.service.IPositionService;
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
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable,
                           @RequestParam Optional<String> name,
                           @RequestParam Optional<String> email,
                           @RequestParam Optional<String> position) {
        model.addAttribute("positionList", iPositionService.findAll());
        if (name.isPresent() || email.isPresent() || position.isPresent()) {
            String nameVal = name.orElse("");
            String emailVal = email.orElse("");
            String positionVal = position.orElse("");
            model.addAttribute("nameVal", nameVal);
            model.addAttribute("emailVal", emailVal);
            model.addAttribute("positionVal", positionVal);
            model.addAttribute("employeeList", iEmployeeService.findAllByNameContainingAndEmailContainingAndPosition_Id(nameVal, emailVal, positionVal, pageable));
            return "/employee/list";
        } else {
            model.addAttribute("employeeList",iEmployeeService.findAll(pageable));
            return "/employee/list";
        }


    }

    @GetMapping(value = "/employee/create")
    public String create(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationList", iEducationDegreeService.findAll());

        return "/employee/create";
    }

    @PostMapping(value = "/employee/create")
    public String create(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positionList", iPositionService.findAll());
            model.addAttribute("divisionList", iDivisionService.findAll());
            model.addAttribute("educationList", iEducationDegreeService.findAll());
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/employee/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(this.iEmployeeService.findById(id), employeeDto);
        model.addAttribute("employeeDto", employeeDto);
//        model.addAttribute("employee", iEmployeeService.findById(id));
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationList", iEducationDegreeService.findAll());

        return "/employee/update";
    }

    @PostMapping(value = "/employee/update")
    public String update(RedirectAttributes redirectAttributes, @ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult, Model model) {
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationList", iEducationDegreeService.findAll());
//      new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/employee/update";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.update(employee);
        redirectAttributes.addFlashAttribute("mess", "da cap nhat thanh cong");
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/employee/delete/{id}")
    public String delete(@PathVariable int id, Model model) {

        model.addAttribute("employee", iEmployeeService.findById(id));
        return "/employee/delete";
    }

    @PostMapping(value = "/employee/delete")
    public String delete(Employee employee, RedirectAttributes redirectAttributes) {

        iEmployeeService.remove(employee.getId());
        redirectAttributes.addFlashAttribute("mess", "da xoa thanh cong");
        return "redirect:/employee/list";
    }
}
