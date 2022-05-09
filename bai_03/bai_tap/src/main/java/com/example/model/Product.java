package com.example.model;

public class Product {
 //id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
    private int id;
    private String productName;
    private int price;
    private String status;
    private String producer;

    public Product() {
    }

    public Product(int id, String productName, int price, String status, String producer) {
        this.id = id;
        this.productName = productName;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
