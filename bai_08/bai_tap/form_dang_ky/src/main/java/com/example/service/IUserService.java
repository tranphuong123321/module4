package com.example.service;

import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
  List<User> findAll();
 void save(User user);
//    Blog findById(int id);
//    void update(int id, Blog blog);
//    void remove(int id);
////    List<Blog> searchByName(String name);
//    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
}
