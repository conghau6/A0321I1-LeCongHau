package com.codegym.validate_song.controller;

import com.codegym.validate_song.model.Song;
import com.codegym.validate_song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("")
    public String showListSong(Model model, @PageableDefault(size = 3) Pageable pageable){
        model.addAttribute("listSong",songService.findAll(pageable));
        return "index";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create","song",new Song());
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "create";
        } else {
            songService.saveSong(song);
            return "redirect:";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Integer id){
        return new ModelAndView("edit","song",songService.findById(id));
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("edit","song",song);
        } else {
            songService.saveSong(song);
            return new ModelAndView("redirect:");
        }
    }

}
