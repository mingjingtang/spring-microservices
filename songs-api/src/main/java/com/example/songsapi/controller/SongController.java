package com.example.songsapi.controller;

import com.example.songsapi.model.Song;
import com.example.songsapi.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {

    private SongService songService;


    @GetMapping("/all")
    public Iterable<Song> getSongs(){return songService.getSongs();}

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteSong(@PathVariable long id){return songService.deleteSongId(id)}

    @PostMapping("/create")
    public HttpStatus createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @PatchMapping("/update/{id}")
    public HttpStatus updateSong(@PathVariable long id, @RequestBody Song songRequest) {
        return songService.updateSong(id, songRequest);
    }

}
