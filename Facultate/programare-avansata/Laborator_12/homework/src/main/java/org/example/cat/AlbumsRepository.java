package org.example.cat;

import java.util.List;

public class AlbumsRepository {
    public Album create(Object... params) {
        long start = System.currentTimeMillis();
        String title = (String) params[0];
        int releaseYear = (int) params[1];
        Artist artist = (Artist) params[2];
        List<Genre> genres = (List<Genre>) params[3];
        Album album = new Album(releaseYear, title, artist, genres);
        long end = System.currentTimeMillis();
        System.out.println("The execution of insert in albums was " + (end - start) + " milliseconds.");
        return album;
    }
}