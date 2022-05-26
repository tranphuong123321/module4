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

    private String poolArea;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "^$|^[+]?\\d*\\.?\\d*$", message = "phai la so duong")
    private String numberOfFloors;



    private FacilityType facilityType;


    private RentType rentType;

}
