package com.example.dto;

import com.example.model.Contract;
import com.example.model.FacilityType;
import com.example.model.RentType;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

public class FacilityDto {
    private int id;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^DV-\\d{4}$",message = "khong dung dinh dang")
    private String code;
    @NotBlank(message = "khong duoc de trong")
    private String name;
    @NotBlank(message = "khong duoc de trong")
    private String area;
    @NotBlank(message = "khong duoc de trong")
   @Pattern(regexp = "^$|^[+]?\\d*\\.?\\d*$", message = "phai la so duong")

    private String cost;
    @NotBlank(message = "khong duoc de trong")
    private String maxPeople;

    private String standardRoom;
    private String descriptionOtherConvenience;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^[+]?\\d*\\.?\\d*$", message = "phai la so duong")
    private String poolArea;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^[+]?\\d*\\.?\\d*$", message = "phai la so duong")
    private String numberOfFloors;
    private FacilityType facilityType;
    private RentType rentType;

    public FacilityDto() {
    }

    public FacilityDto(int id, String code, String name, String area, String cost, String maxPeople, String standardRoom, String descriptionOtherConvenience, String poolArea, String numberOfFloors, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityType = facilityType;
        this.rentType = rentType;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
