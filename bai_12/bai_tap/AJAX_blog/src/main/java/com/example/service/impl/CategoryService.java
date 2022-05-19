package com.example.service.impl;

import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {


        @Autowired
        private ICategoryRepository iCategoryRepository;

        @Override
        public List<Category> findAll() {
            return iCategoryRepository.findAll();
        }

        @Override
        public void save(Category category) {
            iCategoryRepository.save(category);
        }

        @Override
        public void deleteById(Integer id) {
            iCategoryRepository.deleteById(id);
        }

        @Override
        public Optional<Category> findById(Integer id) {
            return iCategoryRepository.findById(id);
        }
    }