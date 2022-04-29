package com.example.service.impl;

import com.example.repository.ITranslateRepository;
import com.example.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class TranslateService implements ITranslateService {
@Autowired
    ITranslateRepository iTranslateRepository;

    @Override
    public Map<String, String> findAll() {
        return iTranslateRepository.findAll();
    }
}
