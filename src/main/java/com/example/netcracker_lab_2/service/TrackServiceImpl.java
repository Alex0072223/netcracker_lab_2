package com.example.netcracker_lab_2.service;

import com.example.netcracker_lab_2.commands.TrackCommand;
import com.example.netcracker_lab_2.converters.TrackCommandToTrack;
import com.example.netcracker_lab_2.converters.TrackToTrackCommand;
import com.example.netcracker_lab_2.domain.Track;
import com.example.netcracker_lab_2.repositiry.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final GenreService genreService;
    private final TrackToTrackCommand trackToTrackCommand;
    private final TrackCommandToTrack trackCommandToTrack;

    public TrackServiceImpl(TrackRepository trackRepository, GenreService genreService, TrackToTrackCommand trackToTrackCommand, TrackCommandToTrack trackCommandToTrack) {
        this.trackRepository = trackRepository;
        this.genreService = genreService;
        this.trackToTrackCommand = trackToTrackCommand;
        this.trackCommandToTrack = trackCommandToTrack;
    }

    @Override
    public List<Track> findAll() {
        List<Track> trackList = new LinkedList<>();
        trackRepository.findAll().iterator().forEachRemaining(trackList::add);
        return trackList;
    }

    @Override
    public List<Track> findByTemplate(String template) {
        List<Track> trackList = findAll();

        String lowerTemplate = template.toLowerCase(Locale.ROOT);

        return trackList.stream()
                .filter(track -> track.getName().toLowerCase(Locale.ROOT).contains(lowerTemplate) ||
                        track.getAuthor().toLowerCase(Locale.ROOT).contains(lowerTemplate) ||
                        track.getAlbum().toLowerCase(Locale.ROOT).contains(lowerTemplate) ||
                        track.getGenre().getName().toLowerCase(Locale.ROOT).contains(lowerTemplate))
                .collect(Collectors.toList());
    }

    @Override
    public Track findById(Integer id) {
        return trackRepository.findById(id).orElse(null);
    }

    @Override
    public TrackCommand saveTrackCommand(TrackCommand trackCommand) {
        Track detachedTrack = trackCommandToTrack.convert(trackCommand);

        Track savedTrack = trackRepository.save(detachedTrack);

        return trackToTrackCommand.convert(savedTrack);
    }

    @Override
    public void deleteById(Integer id) {
        trackRepository.deleteById(id);
    }

    @Override
    public TrackCommand findCommandById(Integer id) {
        return trackToTrackCommand.convert(findById(id));
    }
}
