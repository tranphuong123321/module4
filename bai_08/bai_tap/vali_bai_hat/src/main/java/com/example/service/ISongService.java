package com.example.service;

import com.example.model.Song;


import java.util.List;

public interface ISongService {
  List<Song> findAll();
 void save(Song song);
//    Blog findById(int id);
//    void update(int id, Blog blog);
//    void remove(int id);
////    List<Blog> searchByName(String name);
//    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
}
