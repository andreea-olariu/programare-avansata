
import org.example.ArtistDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArtistDAOTest {

    ArtistDAO artistDAO;

    @BeforeEach
    void setup() {
        artistDAO = new ArtistDAO();
        try {
            artistDAO.create("Alternosfera");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Finding the id based on name should work")
    void findByNameTest() throws SQLException {
        Integer id = 10;
        List<Integer> result = Collections.singletonList(artistDAO.findByName("Alternosfera"));
        assertTrue(result.contains(id));
    }

}
