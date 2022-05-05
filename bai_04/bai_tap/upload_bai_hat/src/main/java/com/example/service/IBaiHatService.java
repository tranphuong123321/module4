package com.example.service;

import com.example.model.BaiHat;

import java.util.List;

public interface IBaiHatService {
    void upload(BaiHat baiHat);
    List<BaiHat> findAll();
}
