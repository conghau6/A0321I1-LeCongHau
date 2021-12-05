package com.codegym.validate_song.repositories;

import com.codegym.validate_song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepositories extends JpaRepository<Song, Integer> {

}
