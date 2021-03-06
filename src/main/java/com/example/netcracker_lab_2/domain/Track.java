package com.example.netcracker_lab_2.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Simple business object representing a Track
 */
@Entity

@Getter
@Setter
@ToString
@NoArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Track implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String author;
    String album;
    Integer duration;


    public Integer getId() {
        return id;
    }
    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    @XmlElement
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }
    @XmlElement
    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getDuration() {
        return duration;
    }
    @XmlElement
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @ManyToOne
    Genre genre;

    @Builder
    public Track(Integer id, String name, String author, String album, Integer duration, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
    }
}
