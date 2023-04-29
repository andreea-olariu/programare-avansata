package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Album extends Entity {
    private int releaseYear;
    private String title;
    private Artist artist;

    private List<Genre> genres;
    public Album(int id, int releaseYear, String title, Artist artist, List<Genre> genres) {
        super(id);
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }
}
