package com.example.service.impl;

import com.example.model.BaiHat;
import com.example.service.IBaiHatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaiHatService implements IBaiHatService {

static List<BaiHat> listBaiHat = new ArrayList<>();
    @Override
    public void upload(BaiHat baiHat) {
listBaiHat.add(baiHat);
    }

    @Override
    public List<BaiHat> findAll() {
        return listBaiHat;
    }
}
