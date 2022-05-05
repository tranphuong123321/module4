package com.example.model;

public class BaiHat {
    private String tenBaiHat;
    private String ngheSi;
    private String theLoai;
    private String duongDan;

    public BaiHat() {
    }

    public BaiHat(String tenBaiHat, String ngheSi, String theLoai, String duongDan) {
        this.tenBaiHat = tenBaiHat;
        this.ngheSi = ngheSi;
        this.theLoai = theLoai;
        this.duongDan = duongDan;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }
}
