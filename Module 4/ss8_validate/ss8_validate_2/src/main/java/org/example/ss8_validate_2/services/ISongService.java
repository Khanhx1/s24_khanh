package org.example.ss8_validate_2.services;

import org.example.ss8_validate_2.models.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(Integer id);

    void updateSong(Song song);
}
