package com.example.controller;

import com.example.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    ITranslateService iTranslateService;

    @GetMapping(value = "/home")
    public String home() {
        return "/home";
    }

    @GetMapping(value = "/translate")
    public String translate(@RequestParam String text, Model model) {
        String result = this.iTranslateService.findAll().get(text);
        
        model.addAttribute("result", result);
        model.addAttribute("text", text);
        return "translate";
    }
}

