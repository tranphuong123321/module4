package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "ko duoc de trong")
    @Pattern(regexp = "^\\w{8}$" ,message = "ko dung dinh dang")
    private String name;
    @NotBlank(message = "ko duoc de trong")
    @Pattern(regexp = "^\\w{1,300}$" ,message = "ko dung dinh dang")
    private String artist;
    @NotBlank(message = "ko duoc de trong")
    @Pattern(regexp = "^\\w{1,1000}$" ,message = "ko dung dinh dang")
    private String type;

    public Song() {
    }

    public Song(int id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
