package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/blog/list")
    public String list(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("blogList", this.iBlogService.findAllByNameContaining(keywordVal, pageable));

        return "/blog/list";
    }

    @GetMapping(value = "/blog/create")
    public String create(Model model, Blog blog) {
        blog.setDay(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "/blog/create";
    }

    @PostMapping(value = "/blog/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        blog.setId((int) (Math.random() * 10000));
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/blog/edit/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("blog", this.iBlogService.findById(id));
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "/blog/update";
    }

    @PostMapping(value = "/blog/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.update(blog.getId(), blog);
        redirectAttributes.addFlashAttribute("mess", "da cap nhat thanh cong");
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/blog/delete/{id}")
    public String delete(@PathVariable int id, Model model) {

        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping(value = "/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {

        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess", "da xoa thanh cong");
        return "redirect:/blog/list";
    }
}
