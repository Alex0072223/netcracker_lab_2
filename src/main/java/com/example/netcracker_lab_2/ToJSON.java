package com.example.netcracker_lab_2;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ToJSON {
    @JsonProperty("Id")
    private long id;

    @JsonProperty("Name of track")
    private String name;



    @JsonProperty("Name of Author")
    private String author;

    @JsonProperty("Name of Album")
    private String album;

    @JsonIgnore
    private String level;

    public ToJSON() {
    }

    public ToJSON(long id, String name, String album, String level) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.level = level;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String phone) {
        this.album = phone;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Element[ID:" + id + ", Track: " + name + ", Album: " + album + "]";
    }
}
