package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    //id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private int price;
    private String status;
    private String producer;
    private String funtion;

    public Product() {
    }

    public Product(int id, String name, int price, String status, String producer, String funtion) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.producer = producer;
        this.funtion = funtion;
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

    public String getFuntion() {
        return funtion;
    }

    public void setFuntion(String funtion) {
        this.funtion = funtion;
    }
}
