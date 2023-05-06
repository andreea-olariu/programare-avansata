package Repositories;

import org.example.DatabaseOperations;
import org.example.Models.Album;
import org.example.Models.Artist;
import org.example.Models.Genre;
import org.example.Repositories.AlbumsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlbumsRepositoryTest {

    AlbumsRepository albumsRepository;

    @BeforeEach
    public void setUp() {
        albumsRepository = new AlbumsRepository();
        DatabaseOperations.getEm().getTransaction().begin();
    }

    @DisplayName("Find by title test")
    @Test
    void findByTitleTest() {
        Artist artist = new Artist("Artist test");
        Genre genre = new Genre("Genre test");

        DatabaseOperations.getEm().persist(artist);
        DatabaseOperations.getEm().persist(genre);

        Album album = albumsRepository.create("Album test", 2000, artist, List.of(genre));

        Album result = albumsRepository.findByTitle("Album test");
        assertEquals(result, album);
    }

    @DisplayName("Find all test")
    @Test
    void findAllTest() {
        Artist artist = new Artist("Artist test");
        Genre genre = new Genre("Genre test");

        DatabaseOperations.getEm().persist(artist);
        DatabaseOperations.getEm().persist(genre);

        Album album = albumsRepository.create("Album test", 2000, artist, List.of(genre));

        List<Album> result = albumsRepository.findAll();
        assertTrue(result.contains(album));
    }

    @AfterEach
    public void closeConnection() {
        DatabaseOperations.getEm().getTransaction().rollback();
    }
}
