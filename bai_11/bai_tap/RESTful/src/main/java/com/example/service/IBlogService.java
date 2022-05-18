package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAllPaging( Pageable pageable);
    //    List<Category> findAll();
   void save(Blog blog);
// Blog findById(int id);
//   void update(int id, Blog blog);
//   void remove(int id);
Optional<Blog> findById(Integer id);

    void deleteById(Integer id);
}
