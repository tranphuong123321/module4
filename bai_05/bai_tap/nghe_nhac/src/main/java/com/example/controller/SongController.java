package com.example.controller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("songList", iSongService.findAll());
        return "/home";
    }

    @GetMapping(value = "/create")
    public String create(Model model, Song song) {
        model.addAttribute("song", song);
        return "/create";
    }

    @PostMapping(value = "/save")
    public String create(Song song, RedirectAttributes redirectAttributes) {
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess", "da tao moi thanh cong");
        return "redirect:/home";
    }

    @GetMapping(value = "/update/{id}")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("song", iSongService.findById(id));
        return "/update";
    }

    @PostMapping(value = "/update")
    public String update(Song song, RedirectAttributes redirectAttributes) {
        iSongService.update(song.getId(), song);
        redirectAttributes.addFlashAttribute("mess", "da cap nhat thanh cong");
        return "redirect:/home";
    }
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("song",iSongService.findById(id));
        return "/delete";
    }
    @PostMapping(value="/delete")
    public String delete(Song song, RedirectAttributes redirectAttributes){
        iSongService.remove(song.getId());
        redirectAttributes.addFlashAttribute("mess","da xoa thanh cong");
        return "redirect:/home";
    }
}
