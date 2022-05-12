package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/home")
    public String home(Model model,
                       @PageableDefault(value = 2) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("blogList", iBlogService.findAllByNameContaining(keywordVal, pageable));
        return "/blog/home";
    }

    @GetMapping(value = "/create")
    public String create(Model model, Blog blog) {
        blog.setDay(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "/blog/create";
    }

    @PostMapping(value = "/save")
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/blog/home";
    }

    @GetMapping(value = "/edit/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/update";
    }

    @PostMapping(value = "/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog.getId(), blog);
        redirectAttributes.addFlashAttribute("mess", "da chinh sua thanh cong");
        return "redirect:/blog/home";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping(value = "/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess", "da xoa thanh cong");
        return "redirect:/blog/home";
    }
//    @GetMapping (value = "/search")
//    public  String search(@RequestParam("name") String name, Model model){
//     //   System.out.println(name);
//
//        model.addAttribute("blogList",iBlogService.searchByName(name));
////        System.out.println(iBlogService.searchByName(name).toString());
//        return "/home";
//    }
}
