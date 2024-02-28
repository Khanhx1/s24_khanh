package org.example.ss8_validate_2.controllers;

import org.example.ss8_validate_2.models.Song;
import org.example.ss8_validate_2.services.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String showListSong(Model model){
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList", songList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@Validated @ModelAttribute("song")Song song, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "create";
        }
        iSongService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String ShowEditPage(@PathVariable("id")Integer id, Model model){
        Song song = iSongService.findById(id);
        model.addAttribute("song", song);
        return "edit";
    }
    @PostMapping("/edit")
    public String updateSong(@Validated @ModelAttribute("song")Song song, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        iSongService.updateSong(song);
        return "redirect:/song";
    }
}
