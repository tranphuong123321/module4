package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String link;


    @Column(columnDefinition = "DATE")
    private String day;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String name, String link, String day, Category category) {
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
}
