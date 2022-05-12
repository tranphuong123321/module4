package com.example.controller;

import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/user/list")
    public String list(Model model) {
        model.addAttribute("userList", iUserService.findAll());
        return "/user/list";
    }

    @GetMapping(value = "/user/create")
    public String create(Model model, User user) {
        model.addAttribute("user", user);
        return "/user/create";
    }

    @PostMapping(value = "/user/save")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/create";
        }
        iUserService.save(user);
        return "redirect:/user/list";
    }
}
