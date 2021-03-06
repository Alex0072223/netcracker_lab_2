package com.example.netcracker_lab_2.controllers;

import com.example.netcracker_lab_2.service.GenreService;
import com.example.netcracker_lab_2.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    private final TrackService trackService;
    private final GenreService genreService;

    public IndexController(TrackService trackService, GenreService genreService) {
        this.trackService = trackService;
        this.genreService = genreService;
    }

    @RequestMapping({"/", ""})
    public String init() {
        return "index";

    }

    @GetMapping({"/find", "/find/"})
    public String find(@RequestParam String template, Model model) {

        model.addAttribute("tracks", trackService.findAllByNameAlbumAuthorLike(template));

        model.addAttribute("genres", genreService.findAllByNameLike(template));

        return "index";
    }
}
