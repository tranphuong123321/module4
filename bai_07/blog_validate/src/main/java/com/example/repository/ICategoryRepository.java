package com.example.repository;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Page<Category> findAllByNameContaining(String name, Pageable pageable);
}
