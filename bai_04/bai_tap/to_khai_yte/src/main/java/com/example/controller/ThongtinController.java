package com.example.controller;

import com.example.model.Thongtin;
import com.example.service.IThongtinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ThongtinController {
    @Autowired
    IThongtinService iThongtinService;
    @GetMapping(value="/home")
    public String home(Model model){
        model.addAttribute("thongtin",new Thongtin());
        return "/home";
    }
    @PostMapping(value ="/save")
    public String save(@ModelAttribute Thongtin thongtin, RedirectAttributes redirectAttributes){
        this.iThongtinService.save(thongtin);
        redirectAttributes.addFlashAttribute("mess", "đã gửi tờ khai thành công");
        return  "redirect:/list";
    }
    @GetMapping(value="/list")
    public String thongtinList(Model model){
        model.addAttribute("thongtinList", iThongtinService.findAll());
        return "/list";
    }
}
