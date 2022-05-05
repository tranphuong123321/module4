package com.example.model;

import java.util.Date;

public class Thongtin {
    private String hoTen;
    private String namSinh;
    private String gioiTinh;
    private String quocTich;
    private String chungMinh;
    private String phuongTien;
    private String soHieu;
    private String soGhe;
    private int ngayKhoiHanh;
    private int thangKhoiHanh;
    private int namKhoiHanh;
    private int ngayKetThuc;
    private int thangKetThuc;
    private int namKetThuc;
    private String thanhPho;


    public Thongtin() {
    }

    public Thongtin(String hoTen, String namSinh, String gioiTinh, String quocTich, String chungMinh, String phuongTien, String soHieu, String soGhe, int ngayKhoiHanh, int thangKhoiHanh, int namKhoiHanh, int ngayKetThuc, int thangKetThuc, int namKetThuc, String thanhPho) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.chungMinh = chungMinh;
        this.phuongTien = phuongTien;
        this.soHieu = soHieu;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.thangKhoiHanh = thangKhoiHanh;
        this.namKhoiHanh = namKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.thangKetThuc = thangKetThuc;
        this.namKetThuc = namKetThuc;
        this.thanhPho = thanhPho;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getChungMinh() {
        return chungMinh;
    }

    public void setChungMinh(String chungMinh) {
        this.chungMinh = chungMinh;
    }

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public int getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(int ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public int getThangKhoiHanh() {
        return thangKhoiHanh;
    }

    public void setThangKhoiHanh(int thangKhoiHanh) {
        this.thangKhoiHanh = thangKhoiHanh;
    }

    public int getNamKhoiHanh() {
        return namKhoiHanh;
    }

    public void setNamKhoiHanh(int namKhoiHanh) {
        this.namKhoiHanh = namKhoiHanh;
    }

    public int getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(int ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getThangKetThuc() {
        return thangKetThuc;
    }

    public void setThangKetThuc(int thangKetThuc) {
        this.thangKetThuc = thangKetThuc;
    }

    public int getNamKetThuc() {
        return namKetThuc;
    }

    public void setNamKetThuc(int namKetThuc) {
        this.namKetThuc = namKetThuc;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }
}
