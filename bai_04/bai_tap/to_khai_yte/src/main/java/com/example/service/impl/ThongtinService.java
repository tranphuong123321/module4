package com.example.service.impl;

import com.example.model.Thongtin;
import com.example.service.IThongtinService;
import org.springframework.stereotype.Service;

@Service
public class ThongtinService implements IThongtinService {
    private  static Thongtin thongtin = new Thongtin();
    @Override
    public void save(Thongtin thongtin) {

    }
}
