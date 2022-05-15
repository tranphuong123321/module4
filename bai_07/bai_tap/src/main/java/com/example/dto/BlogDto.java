package com.example.dto;

import com.example.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BlogDto implements Validator {
    private int id;
    private String name;
    private String link;
    private String day;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(int id, String name, String link, String day, Category category) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.day = day;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDto blogDto = (BlogDto) target;
        if (blogDto.name.equals("")) {
            errors.rejectValue("name", "string.blank", "loi mac dinh");
        }
        if (blogDto.link.equals("")) {
            errors.rejectValue("link", "string.blank", "loi mac dinh");
        }
        if (blogDto.category.equals("")) {
            errors.rejectValue("category", "string.blank", "loi mac dinh");
        }
    }
}
