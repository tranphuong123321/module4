package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "/category/list")
    public ResponseEntity<Page<Category>> getPageCategory(@PageableDefault(value = 2) Pageable pageable) {
        Page<Category> categoryPage = iCategoryService.findAllPaging(pageable);
        if (!categoryPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryPage, HttpStatus.OK);
    }
}
