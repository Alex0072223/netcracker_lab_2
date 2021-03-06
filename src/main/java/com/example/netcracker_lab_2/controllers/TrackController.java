package com.example.netcracker_lab_2.controllers;

import com.example.netcracker_lab_2.commands.GenreCommand;
import com.example.netcracker_lab_2.commands.TrackCommand;
import com.example.netcracker_lab_2.service.GenreService;
import com.example.netcracker_lab_2.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/track")
public class TrackController {
    private final TrackService trackService;
    private final GenreService genreService;

    public TrackController(TrackService trackService, GenreService genreService) {
        this.trackService = trackService;
        this.genreService = genreService;
    }

    @GetMapping({"new/", "new"})
    public String newTrack(Model model) {
        model.addAttribute("track", TrackCommand.builder().genreCommand(GenreCommand.builder().build()).build());

        model.addAttribute("genreList", genreService.findAll());

        return "databaseDirectory/track/new";
    }

    @GetMapping({"", "/"})
    public String allTrack(Model model) {
        model.addAttribute("tracks", trackService.findAll());

        return "databaseDirectory/track/database";
    }

    @GetMapping({"{id}/update/", "{id}/update"})
    public String updateTrack(@PathVariable Integer id, Model model) {
        model.addAttribute("track", trackService.findCommandById(id));

        model.addAttribute("genreList", genreService.findAll());

        return "databaseDirectory/track/new";
    }

    @GetMapping({"{id}/delete/", "{id}/delete"})
    public String deleteTrack(@PathVariable Integer id) {
        trackService.deleteById(id);
        return "redirect:/track/";
    }

    @PostMapping({"saveOrUpdate/", "saveOrUpdate"})
    public String saveOrUpdateTrack(@ModelAttribute TrackCommand command) {
        TrackCommand savedCommand = trackService.saveTrackCommand(command);
        return "redirect:/track/";
    }
}
