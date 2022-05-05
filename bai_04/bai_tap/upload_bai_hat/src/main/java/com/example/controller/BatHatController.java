package com.example.controller;

import com.example.model.BaiHat;
import com.example.service.IBaiHatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BatHatController {

    @Autowired
    IBaiHatService iBaiHatService;
    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("baihat", new BaiHat());
        return "/home";
    }

    @PostMapping(value = "/upload")
    public String upload(@ModelAttribute BaiHat baiHat) {
        this.iBaiHatService.upload(baiHat);
        return "redirect:/list";
    }
    @GetMapping(value="/list")
    public String listBaiHat(Model model){
        model.addAttribute("listBaiHat", iBaiHatService.findAll());
        return "/list";
    }
}
