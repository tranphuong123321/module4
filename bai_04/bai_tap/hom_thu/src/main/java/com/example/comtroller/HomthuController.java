package com.example.comtroller;

import com.example.model.HomThu;
import com.example.service.IHomThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomthuController {
    @Autowired
    IHomThuService iHomThuService;
    @GetMapping(value="/home")
    public String home(Model model){
        model.addAttribute("homthu", new HomThu());
        return "/home";
    }
    @GetMapping(value="/update")
    public String update(@ModelAttribute HomThu homThu , RedirectAttributes redirectAttributes){

        this.iHomThuService.save(homThu);
        redirectAttributes.addFlashAttribute("mess","da cap nhat thanh cong");
        return  "redirect:/home";
    }
}
