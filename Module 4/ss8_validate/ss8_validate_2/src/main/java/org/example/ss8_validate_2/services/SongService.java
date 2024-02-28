package org.example.ss8_validate_2.services;

import org.example.ss8_validate_2.models.Song;
import org.example.ss8_validate_2.repositories.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id).orElse(null);
    }

    @Override
    public void updateSong(Song song) {
        iSongRepository.save(song);
    }
}
