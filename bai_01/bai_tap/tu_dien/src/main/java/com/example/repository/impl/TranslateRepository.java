package com.example.repository.impl;

import com.example.repository.ITranslateRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TranslateRepository implements ITranslateRepository {
    @Override
    public Map<String, String> findAll() {
        Map<String, String> list = new HashMap<>();
        list.put("dog", "con cho");
        list.put("cat", "con meo");
        list.put("lion", "con su tu");

        return list;
    }
}
