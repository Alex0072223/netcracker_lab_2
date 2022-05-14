package com.example.netcracker_lab_2.commands;

import com.sun.xml.txw2.annotation.XmlElement;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Transfers data between view and model
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackCommand {
    Integer id;
    String name;
    String author;
    String album;
    Integer duration;
    GenreCommand genreCommand;
}
