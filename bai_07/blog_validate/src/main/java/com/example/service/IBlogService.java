package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService  {
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    //    List<Category> findAll();
    void save(Blog blog);
   Blog findById(int id);
   void update(int id, Blog blog);
   void remove(int id);
}
