package org.example.ss8_validate_2.repositories;

import org.example.ss8_validate_2.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
