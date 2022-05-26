package com.example.dto;

import com.example.model.Division;
import com.example.model.EducationDegree;
import com.example.model.Position;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private int id;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^KH-\\d{4}$",message = "khong dung dinh dang")
    private String code;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^\\p{Lu}\\p{Ll}+( \\p{Lu}\\p{Ll}+)*$", message = "ko dung dinh dang")
    private String name;
    @NotBlank(message = "khong duoc de trong")
    private String birthDay;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^\\d{9}$", message = "ko dung dinh dang")
    private String idCard;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^[+]?\\d*\\.?\\d*$", message = "phai la so duong")
    private String salary;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp =" ^$|^((\\(84\\)\\+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7}$", message = "ko dung dinh dang")
    private String numberPhone;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^([a-z]\\w+@[a-z]{2,}\\.)\\w{2,10}(\\.\\w{2,3})?$", message = "ko dung dinh dang")
    private String email;
    @NotBlank(message = "khong duoc de trong")
    private String address;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String code, String name, String birthDay, String idCard, String salary, String numberPhone, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
