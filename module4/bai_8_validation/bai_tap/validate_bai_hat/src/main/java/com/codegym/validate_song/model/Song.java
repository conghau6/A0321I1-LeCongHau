package com.codegym.validate_song.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(min = 0, max = 800, message = "Không vượt qua 800 ký tự")
    @Pattern(regexp = "^[^\\;\\,\\.\\=\\-\\+]+$", message = "Dữ liệu không hợp lệ")
    private String nameSong;

    @NotBlank(message = "Tên nghệ sĩ không được để trống")
    @Size(min = 0, max = 300, message = "Không vượt qua 300 ký tự")
    @Pattern(regexp = "^[^\\;\\,\\.\\=\\-\\+]+$", message = "Dữ liệu không hợp lệ")
    private String nameSinger;

    @NotBlank(message = "Tên thể loại không được để trống")
    @Size(min = 0, max = 1000, message = "Không vượt qua 1000 ký tự")
    @Pattern(regexp = "^[^\\;\\.\\=\\-\\+]+$", message = "Dữ liệu không hợp lệ")
    private String category;

    public Song() {
    }

    public Song(@NotBlank(message = "Tên bài hát không được để trống") @Size(min = 0, max = 800, message = "Không vượt qua 800 ký tự") @Pattern(regexp = "^[^\\;\\,\\.\\=\\-\\+]+$", message = "Dữ liệu không hợp lệ") String nameSong, @NotBlank(message = "Tên nghệ sĩ không được để trống") @Size(min = 0, max = 300, message = "Không vượt qua 300 ký tự") @Pattern(regexp = "^[^\\;\\,\\.\\=\\-\\+]+$", message = "Dữ liệu không hợp lệ") String nameSinger, @NotBlank(message = "Tên thể loại không được để trống") @Size(min = 0, max = 1000, message = "Không vượt qua 1000 ký tự") @Pattern(regexp = "^[^\\;\\.\\=\\-\\+]+$", message = "Dữ liệu không hợp lệ") String category) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
