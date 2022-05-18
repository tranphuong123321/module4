package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
 //   Page<Category> findAllByNameContaining(String name, Pageable pageable);
//   List<Category> findAll();
//   void save(Category category);
//   Category findById(int id);
//   void update(int id, Category category);
//   void remove(int id);
 Page<Category> findAllPaging(Pageable pageable);
}
