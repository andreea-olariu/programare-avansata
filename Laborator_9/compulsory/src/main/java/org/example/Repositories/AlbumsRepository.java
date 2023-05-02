package org.example.Repositories;

import org.example.DatabaseOperations;
import org.example.Models.Album;
import org.example.Models.Artist;
import org.example.Models.Genre;

import java.util.List;

public class AlbumsRepository {
    public static Album create(String title, int releaseYear, Artist artist, List<Genre> genres) {
        Album album = new Album(releaseYear, title, artist, genres);

        // TODO: if artist or genres are not in the DB, add them

        DatabaseOperations.getEm().persist(album);
        return album;
    }

    public static List<Album> findAll() {
        return DatabaseOperations.getEm().createNamedQuery("Album.findAll")
                .getResultList();
    }

    public static Album findById(int id) {
        return (Album) DatabaseOperations.getEm().createNamedQuery("Album.findById")
                .setParameter(1, id)
                .getResultList()
                .get(0);
    }

    public static Album findByTitle(String name) {
        return (Album) DatabaseOperations.getEm().createNamedQuery("Album.findByTitle")
                .setParameter(1, name)
                .getResultList()
                .get(0);
    }

}