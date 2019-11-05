package com.example.songsapi.service;


import com.example.songsapi.model.Song;
import org.springframework.http.HttpStatus;

public interface SongService {
    public Iterable<Song> getSongs();

    public HttpStatus deleteSong(long id);

    public HttpStatus createSong(Song song);

    public HttpStatus updateSong(long id, Song song);
}
