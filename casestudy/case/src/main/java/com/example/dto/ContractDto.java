package com.example.dto;

import com.example.model.ContractDetail;
import com.example.model.Customer;
import com.example.model.Employee;
import com.example.model.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ContractDto   {
    private int id;
    @NotBlank(message = "khong duoc de trong")
    private String startDate;
    @NotBlank(message = "khong duoc de trong")
    private String endDate;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^[+]?\\d*\\.?\\d*$", message = "phai la so duong")
    private String deposit;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^[+]?\\d*\\.?\\d*$", message = "phai la so duong")
    private String totalMoney;
    private Customer customer;
    private Facility facility;
    private Employee employee;

    public ContractDto() {
    }

    public ContractDto(int id, String startDate, String endDate, String deposit, String totalMoney, Customer customer, Facility facility, Employee employee) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.customer = customer;
        this.facility = facility;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



}
