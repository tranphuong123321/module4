package com.example.codegym.controller;

import com.example.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private IConvertService iConvertService;

    @GetMapping("/home")
    public String convert() {
        return "/home";
    }

    @GetMapping("/convert")
    public String result(@RequestParam double usd, Model model) {

        model.addAttribute("result", iConvertService.convert(usd));
        return "result";
    }
}
