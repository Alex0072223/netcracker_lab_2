package com.example.netcracker_lab_2.bootstrap;

import com.example.netcracker_lab_2.NetcrackerLab2Application;
import com.example.netcracker_lab_2.domain.Track;
import com.example.netcracker_lab_2.repositiry.GenreRepository;
import com.example.netcracker_lab_2.repositiry.TrackRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Class meant to load data t database
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final TrackRepository trackRepository;
    private final GenreRepository genreRepository;

    public DataLoader(TrackRepository trackRepository, GenreRepository genreRepository) {
        this.trackRepository = trackRepository;
        this.genreRepository = genreRepository;
    }

    /**
     * Loads data every time application restarts
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        trackRepository.saveAll(getTracks());
    }

    private List<Track> getTracks() {
        List<Track> trackList = new LinkedList<>();

        Track track1 = Track.builder()
                .name("Montero")
                .author("Lil Nas X")
                .album("Montero")
                .duration(180)
                .genre(genreRepository.findByName("rap").orElse(null))
                .build();

        Track track2 = Track.builder()
                .name("Космос")
                .author("Лизер")
                .album("Молодость, Ч.1")
                .duration(211)
                .genre(genreRepository.findByName("русская").orElse(null))
                .build();




        trackList.add(track1);
        trackList.add(track2);

        return trackList;
    }
}
