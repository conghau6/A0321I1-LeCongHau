package com.codegym.validate_song.service;

import com.codegym.validate_song.model.Song;
import com.codegym.validate_song.repositories.SongRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    SongRepositories songRepositories;
    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepositories.findAll(pageable);
    }

    @Override
    public void saveSong(Song song) {
        songRepositories.save(song);
    }

    @Override
    public void deleteSong(Integer id) {
        songRepositories.deleteById(id);
    }

    @Override
    public Song findById(Integer id) {
        return songRepositories.findById(id).orElse(null);
    }
}
