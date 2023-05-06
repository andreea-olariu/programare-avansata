package org.example;

import com.github.javafaker.Faker;
import com.opencsv.exceptions.CsvException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Models.Album;
import org.example.Models.Artist;
import org.example.Models.Genre;
import org.example.Repositories.AlbumsRepository;
import org.example.Repositories.ArtistRepository;
import org.example.Repositories.GenreRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

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

    public static void testJPA() throws IOException, CsvException {
        DataManipulationTool tool = new DataManipulationTool();
        AlbumsRepository albumsRepository = new AlbumsRepository();
        ArtistRepository artistRepository = new ArtistRepository();
        GenreRepository genreRepository = new GenreRepository();
        createEntityManager();

        em.getTransaction().begin();

//        Artist artist = new Artist("Alternosfera");
//        Genre genre = new Genre("super");
//        Album album = new Album(2019, "Arhitectul din Babel", artist, List.of(genre));
//
//        em.persist(genre);
//        em.persist(artist);
//        em.persist(album);
//
//        System.out.println(albumsRepository.findAll());
//        albumsRepository.create("Epizodia", 2008, artist, List.of(genre));
//        System.out.println(albumsRepository.findByTitle("Arhitectul din Babel"));

        /* Insert artist */
        List<String[]> albumsListInfo = tool.read();
        for(String[] albumInfo : albumsListInfo) {
            Artist artist = artistRepository.create(albumInfo[3]);
            List<Genre> genres = new ArrayList<>();
            for(String genre : albumInfo[4].split("/|,|&")) {
                String genreFinalName = tool.genreName(genre);
                if(!genreFinalName.equals("")) {
                    genres.add(genreRepository.create(genreFinalName));
                }
            }

            albumsRepository.create(albumInfo[2], parseInt(albumInfo[1]), artist, genres);
        }

        em.getTransaction().commit();
    }

    public static void closeEntityManager() {
        em.close();
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }
}
