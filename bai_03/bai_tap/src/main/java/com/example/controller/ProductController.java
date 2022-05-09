package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "/home";
    }

    @GetMapping(value = "/create")
    public String showCreate(Product product,  Model model) {
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping(value = "/save")
    public String create(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess","da tao moi thanh cong");
        return "redirect:/home";
    }
    @GetMapping(value="/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";

    }
    @PostMapping(value="/saveedit")
    public String update(Product product, RedirectAttributes redirectAttributes){
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("mess","da  chinh sua thanh cong");
        return "redirect:/home";
    }
    @GetMapping(value="/delete/{id}")
    public  String delete (@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return"/delete";

    }
    @PostMapping(value="/delete")
    public String delete (Product product, RedirectAttributes redirectAttributes){
        iProductService.delete(product.getId());
        redirectAttributes.addFlashAttribute("mess","da xoa thanh cong");
        return "redirect:/home";
    }
    @GetMapping(value = "/view/{id}")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "view";
    }
    @PostMapping(value = "/search")
    public  String search(@RequestParam("name") String productName, Model model){
        System.out.println(productName);
//        List<Product> productList = iProductService.searchByName(name);
        model.addAttribute("productList",iProductService.searchByName(productName));
        System.out.println(iProductService.searchByName(productName).toString());
        return "home";
    }
}
