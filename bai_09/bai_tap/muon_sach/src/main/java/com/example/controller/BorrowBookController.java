package com.example.controller;

import com.example.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BorrowBookController {
    @Autowired
   private IBorrowBookService iBorrowBookService;

    @GetMapping(value = "/borrowbook/list")
    public String list(Model model){

        model.addAttribute("borrowbookList",iBorrowBookService.findAll());
        return "/borrowbook/list";
    }


}
