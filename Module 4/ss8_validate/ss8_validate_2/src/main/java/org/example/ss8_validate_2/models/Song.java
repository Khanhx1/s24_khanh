package org.example.ss8_validate_2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-z0-9\s]+$", message = "Ten khong chua ky tu dac biet")
    @Size(max = 800, message = "Khong vuot qua 800 ky tu")
    private String name;
    @NotEmpty
    @NotBlank
    @Size(max = 300, message = "Khong vuot qua 300 ky tu")
    @Pattern(regexp = "^[a-z0-9\s]+$", message = "Ten khong chua ky tu dac biet")
    private String artist;
    @NotEmpty
    @NotBlank
    @Size(max = 1000, message = "Khong vuot qua 1000 ky tu")
    @Pattern(regexp = "^[a-zA-Z0-9,\s]+$", message = "khong chua ky tu dac biet ngoai tru dau ,")
    private String category;

    public Song() {
    }

    public Song(Integer id, String name, String artist, String category) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
