package com.codegym.validate_song.service;

import com.codegym.validate_song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {
    Page<Song> findAll(Pageable pageable);
    void saveSong(Song song);
    void deleteSong(int id);
}
