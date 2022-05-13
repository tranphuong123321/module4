package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDto implements Validator {
    private int id;
    private String name;
    private int price;
    private String status;
    private String producer;

    public ProductDto() {
    }

    public ProductDto(int id, String name, int price, String status, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.producer = producer;
    }

    public ProductDto(String name, int price, String status, String producer) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.producer = producer;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if(productDto.name.equals("")){
            errors.rejectValue("name","name.blank","loi mac dinh");
        }

        if(productDto.price<=0){
            errors.rejectValue("price","priceam","none");
        }
        if(productDto.producer.equals("")){
            errors.rejectValue("producer","name.blank","loi mac dinh");
        }
        if(productDto.status.equals("")){
            errors.rejectValue("status","name.blank","loi mac dinh");
        }

    }
}
