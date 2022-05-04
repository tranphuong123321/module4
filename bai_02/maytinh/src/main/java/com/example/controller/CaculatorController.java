package com.example.controller;

import com.example.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CaculatorController {
    @Autowired
    ICaculatorService iCaculatorService;
    @GetMapping(value = "/home")
    public String home() {
        return "/home";
    }

    @GetMapping(value = "/result")
    public String result(Integer num1, Integer num2, String operator, Model model) {
        Integer result=iCaculatorService.caculator( num1,  num2,operator);
        model.addAttribute("result",result);
        return "/result";

    }
}
