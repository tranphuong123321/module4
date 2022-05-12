package com.example.controller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping(value = "/song/list")
    public String list(Model model) {
        model.addAttribute("songList", iSongService.findAll());
        return "/song/list";
    }

    @GetMapping(value = "/song/create")
    public String create(Model model, Song song) {
        model.addAttribute("song", song);
        return "/song/create";
    }

    @PostMapping(value = "/song/save")
    public String create(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/song/create";
        }
        iSongService.save(song);
        return "redirect:/song/list";
    }
}
