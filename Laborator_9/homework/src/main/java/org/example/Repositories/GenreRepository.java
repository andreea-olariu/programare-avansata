package org.example.Repositories;

import org.example.DatabaseOperations;
import org.example.Models.Album;
import org.example.Models.Artist;
import org.example.Models.Genre;

import java.util.List;

public class GenreRepository implements AbstractRepository<Genre>{
    public Genre create(Object... params) {
        long start = System.currentTimeMillis();
        String name = (String) params[0];
        Genre genre = new Genre(name);
        DatabaseOperations.getEm().persist(genre);
        long end = System.currentTimeMillis();
        System.out.println("The execution of insert in albums was " + (end - start) + " milliseconds.");
        return genre;
    }

    public List<Genre> findAll() {
        return DatabaseOperations.getEm().createNamedQuery("Genre.findAll")
                .getResultList();
    }

    public Genre findById(int id) {
        return (Genre) DatabaseOperations.getEm().createNamedQuery("Genre.findById")
                .setParameter(1, id)
                .getResultList()
                .get(0);
    }

    public Genre findByTitle(String name) {
        return (Genre) DatabaseOperations.getEm().createNamedQuery("Genre.findByTitle")
                .setParameter(1, name)
                .getResultList()
                .get(0);
    }

}
