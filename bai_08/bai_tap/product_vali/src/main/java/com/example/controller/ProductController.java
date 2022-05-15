package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
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

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/product/list")
    public String list(Model model, @PageableDefault(value = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("productList", iProductService.findAllByNameContaining(keywordVal, pageable));

        return "/product/list";
    }

    @GetMapping(value = "/product/create")
    public String create(Model model, Product product) {
        model.addAttribute("product", product);
        return "/product/create";
    }

    @PostMapping(value = "/product/create")
    public String create(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/product/list";
    }

    @GetMapping(value = "/product/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        model.addAttribute("product", iProductService.findById(id));
        return "/product/update";
    }

    @PostMapping(value = "/product/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {

        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess", "da cap nhat thanh cong");
        return "redirect:/product/list";
    }

    @GetMapping(value = "/product/delete/{id}")
    public String delete(@PathVariable int id, Model model) {

        model.addAttribute("product", iProductService.findById(id));
        return "/product/delete";
    }

    @PostMapping(value = "/product/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {

        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("mess", " da xoa thanh cong");
        return "redirect:/product/list";
    }
}
