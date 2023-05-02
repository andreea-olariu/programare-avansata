package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Models.Album;
import org.example.Models.Artist;
import org.example.Models.Genre;
import org.example.Repositories.AlbumsRepository;

import java.util.List;

public class DatabaseOperations {
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private DatabaseOperations() {

    }

    public static EntityManagerFactory getEmf() {
        createEntityManagerFactory();
        return emf;
    }

    public static EntityManager getEm() {
        createEntityManager();
        return em;
    }

    public static void createEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        }
    }

    public static void createEntityManager() {
        if (em == null) {
            if (emf == null) {
                createEntityManagerFactory();
            }
            em = emf.createEntityManager();
        }
    }

    public static void testJPA() {
        createEntityManager();

        em.getTransaction().begin();

        Artist artist = new Artist("Alternosfera");
        Genre genre = new Genre("super");
        Album album = new Album(2019, "Arhitectul din Babel", artist, List.of(genre));

        em.persist(genre);
        em.persist(artist);
        em.persist(album);

        System.out.println(AlbumsRepository.findAll());
        AlbumsRepository.create("Epizodia", 2008, artist, List.of(genre));
        System.out.println(AlbumsRepository.findByTitle("Arhitectul din Babel"));

        em.getTransaction().commit();
    }

    public static void closeEntityManager() {
        em.close();
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }
}
