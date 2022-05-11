package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
   private ICategoryService iCategoryService;

    @GetMapping(value = "/category/home")
    public String home(Model model){
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "/category/home";


    }
    @GetMapping(value = "/category/create")
    public String create(Model model, Category category){
        model.addAttribute("category",category);
        return "/category/create";
    }
    @PostMapping(value = "/category/save")
    public String create(Category category, RedirectAttributes redirectAttributes){
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","da them moi thanh cong");
        return "redirect:/category/home";
    }

    @GetMapping(value = "/category/edit/{id}")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "/category/update";

    }
@PostMapping(value = "/category/update")
    public String update(Category category, RedirectAttributes redirectAttributes){

        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("mess","da chinh sua thanh cong");
        return "redirect:/category/home";
}
@GetMapping(value = "/category/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("category",iCategoryService.findById(id));
        return "/category/delete";

}
@PostMapping(value = "/category/delete")
    public String delete(Category category, RedirectAttributes redirectAttributes){

        iCategoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("mess","da xoa thanh cong");
        return "redirect:/category/home";
}

}
