package com.example.songsapi.service;

import com.example.songsapi.model.Song;
import com.example.songsapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
@Service

public class SongServiceImpl implements SongService{

    @Autowired
    private SongRepository songRepository;

    @Override
    public Iterable<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public HttpStatus deleteSong(long id) {
        songRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus createSong(Song song) {
        songRepository.save(song);
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateSong(long id, Song song) {
        Song newsong = songRepository.findById(id).get();
        newsong.setTitle(song.getTitle());
        newsong.setLength(song.getLength());
        songRepository.save(newsong);
        return HttpStatus.OK;
    }
}
