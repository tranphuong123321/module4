package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "khong dc de khoang trang")
    private String firstname;
    @NotBlank(message = "khong dc de khoang trang")
    private String lastname;
    @Pattern(regexp = "\\d{10}",message = "ko dung dinh dang")
    private String phoneNumber;
    @Min(value = 18, message = "tuoi nho nhat phai la 18")
    private String age;
    @Email(message = "ko dung dinh dang")
    @NotBlank(message = "khong dc de khoang trang")
    private String mail;

    public User() {
    }

    public User(int id, String firstname, String lastname, String phoneNumber, String age, String mail) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
