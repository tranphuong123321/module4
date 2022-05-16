package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.hibernate.bytecode.BytecodeLogging;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    public String create(Model model) {

        model.addAttribute("blogDto", new BlogDto());
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "/blog/create";
    }

    @PostMapping(value = "/blog/create")
    public String create( @ModelAttribute @Validated  BlogDto blogDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new BlogDto().validate(blogDto,bindingResult);
        blogDto.setId((int) (Math.random() * 10000));
        blogDto.setDay(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        if(bindingResult.hasFieldErrors()){
            return "/blog/create";
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/blog/edit/{id}")
    public String update(@PathVariable int id, Model model) {
        BlogDto blogDto = new BlogDto();
        BeanUtils.copyProperties( this.iBlogService.findById(id),blogDto);
        model.addAttribute("blogDto",blogDto);
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "/blog/update";
    }

    @PostMapping(value = "/blog/update")
    public String update(@ModelAttribute @Validated  BlogDto blogDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new BlogDto().validate(blogDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/blog/update";
        }
        Blog blog=new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        iBlogService.update(blog.getId(), blog);
        redirectAttributes.addFlashAttribute("mess", "da cap nhat thanh cong");
        return "redirect:/blog/list";
    }

    @GetMapping(value = "/blog/delete/{id}")
    public String delete(@PathVariable int id, Model model) {

        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "/blog/delete";
    }

    @PostMapping(value = "/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {

        iBlogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("mess", "da xoa thanh cong");
        return "redirect:/blog/list";
    }
}
