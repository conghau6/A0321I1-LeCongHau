package com.codegym.validate_song.controller;

import com.codegym.validate_song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("")
    public String showListSong(Model model, @PageableDefault(size = 3) Pageable pageable){
        model.addAttribute("listSong",songService.findAll(pageable));
        return "index";
    }
}
