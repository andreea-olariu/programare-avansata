package org.example.Repositories;

import org.example.DatabaseOperations;
import org.example.Models.Artist;

import java.util.List;

public class ArtistRepository implements AbstractRepository<Artist> {
    public Artist create(Object... params) {
        long start = System.currentTimeMillis();
        String name = (String) params[0];
        Artist artist = new Artist(name);
        DatabaseOperations.getEm().persist(artist);
        long end = System.currentTimeMillis();
        System.out.println("The execution of insert in albums was " + (end - start) + " milliseconds.");
        return artist;
    }

    public List<Artist> findAll() {
        return DatabaseOperations.getEm().createNamedQuery("Artist.findAll")
                .getResultList();
    }

    public Artist findById(int id) {
        return (Artist) DatabaseOperations.getEm().createNamedQuery("Artist.findById")
                .setParameter(1, id)
                .getResultList()
                .get(0);
    }

    public Artist findByTitle(String name) {
        return (Artist) DatabaseOperations.getEm().createNamedQuery("Artist.findByTitle")
                .setParameter(1, name)
                .getResultList()
                .get(0);
    }
}
