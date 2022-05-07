package com.example.service.impl;

import com.example.model.Thongtin;
import com.example.service.IThongtinService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThongtinService implements IThongtinService {
    static List<Thongtin> thongtinList = new ArrayList<>();
    private static Thongtin thongtin = new Thongtin();

    @Override
    public void save(Thongtin thongtin) {
        thongtinList.add(thongtin);
    }

    @Override
    public List<Thongtin> findAll() {
        return thongtinList;
    }
}
