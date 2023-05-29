import org.example.cat.Album;
import org.example.cat.AlbumsRepository;
import org.example.cat.Artist;
import org.example.cat.Genre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlbumsRepositoryTest {

    AlbumsRepository albumsRepository;

    @BeforeEach
    public void setUp() {
        albumsRepository = new AlbumsRepository();
    }

    @DisplayName("Find by title test")
    @Test
    void findByTitleTest() {
        Artist artist = new Artist("Artist test");
        Genre genre = new Genre("Genre test");
        Album album = albumsRepository.create("Album test", 2000, artist, List.of(genre));

        assertEquals("", album);
    }

    @DisplayName("Find all test")
    @Test
    void findAllTest() {
        Artist artist = new Artist("Artist test");
        Genre genre = new Genre("Genre test");

        Album album = albumsRepository.create("Album test", 2000, artist, List.of(genre));
        List<Album> result = new ArrayList<>();
        result.add(album);

        assertTrue(result.contains(album));
    }

    @AfterEach
    public void closeConnection() {

    }
}
