package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
   private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(int id, Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        iBlogRepository.delete(iBlogRepository.getById(id));
    }

    @Override
    public List<Blog> searchByName(String name) {
        List<Blog> blogList1 = new ArrayList<>();
        for (Blog blog: this.findAll()) {
            if ((blog.getName().toLowerCase()).contains(name.toLowerCase())){
                blogList1.add(blog);
            }
        }
        return blogList1;
    }
}
