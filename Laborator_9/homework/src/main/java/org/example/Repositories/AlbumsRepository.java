package org.example.Repositories;

import org.example.DatabaseOperations;
import org.example.Models.Album;
import org.example.Models.Artist;
import org.example.Models.Genre;

import java.util.List;

public class AlbumsRepository implements AbstractRepository<Album> {
    public Album create(Object... params) {
        long start = System.currentTimeMillis();
        String title = (String) params[0];
        int releaseYear = (int) params[1];
        Artist artist = (Artist) params[2];
        List<Genre> genres = (List<Genre>) params[3];
        Album album = new Album(releaseYear, title, artist, genres);
        DatabaseOperations.getEm().persist(album);
        long end = System.currentTimeMillis();
        System.out.println("The execution of insert in albums was " + (end - start) + " milliseconds.");
        return album;
    }

    public List<Album> findAll() {
        return DatabaseOperations.getEm().createNamedQuery("Album.findAll")
                .getResultList();
    }

    public Album findById(int id) {
        return (Album) DatabaseOperations.getEm().createNamedQuery("Album.findById")
                .setParameter(1, id)
                .getResultList()
                .get(0);
    }

    public Album findByTitle(String name) {
        return (Album) DatabaseOperations.getEm().createNamedQuery("Album.findByTitle")
                .setParameter(1, name)
                .getResultList()
                .get(0);
    }

}