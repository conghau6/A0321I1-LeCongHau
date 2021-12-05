package com.codegym.validate_song.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class Song {

    @Id
    @NotNull
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 0, max = 800, message = "Không vượt qua 800 ký tự")
    @Pattern(regexp = "^[^\\;\\,\\.\\=\\-\\+]+$")
    private String nameSong;

    @NotBlank
    @Size(min = 0, max = 300, message = "Không vượt qua 300 ký tự")
    @Pattern(regexp = "^[^\\;\\,\\.\\=\\-\\+]+$")
    private String nameSinger;

    @NotBlank
    @Size(min = 0, max = 1000, message = "Không vượt qua 1000 ký tự")
    @Pattern(regexp = "^[^\\;\\.\\=\\-\\+]+$")
    private String category;

    public Song() {
    }

    public Song(@NotBlank @Size(min = 0, max = 800, message = "Không vượt qua 800 ký tự") @Pattern(regexp = "^[^\\;\\,\\.\\=\\-\\+]+$") String nameSong, @NotBlank @Size(min = 0, max = 300, message = "Không vượt qua 300 ký tự") @Pattern(regexp = "^[^\\;\\,\\.\\=\\-\\+]+$") String nameSinger, @NotBlank @Size(min = 0, max = 1000, message = "Không vượt qua 1000 ký tự") @Pattern(regexp = "^[^\\;\\.\\=\\-\\+]+$") String category) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
