package com.example.service;

import com.example.model.Thongtin;

import java.util.List;

public interface IThongtinService {
    void save(Thongtin thongtin);
    List<Thongtin> findAll();
}
