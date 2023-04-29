package org.example.DAO;

import org.example.Database;
import org.example.Models.Album;
import org.example.Models.Artist;
import org.example.Models.Genre;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AlbumDAO extends EntityDAO {
    ArtistDAO artistDAO = new ArtistDAO();
    GenreDAO genreDAO = new GenreDAO();

    /* order of params: title, release_year, artist name, genres */
    public void create(Object... params) throws SQLException, PropertyVetoException {
        /* insert the artist */
        artistDAO.create(params[2]);
        Integer id = artistDAO.findByName((String) params[2]).getId();
        String query = String.format("insert into albums (title, release_year, artist_id) values (trim('%s'), %d, %d) on conflict do nothing;", params[0], parseInt((String) params[1]), id);
        genericQuery(query);

        for (String genre : (List<String>) params[3]) {
            /* insert the genre */
            genreDAO.create(genre);
            Integer id_album = findByTitle((String) params[0]).getId();
            Integer id_genre = genreDAO.findByName(genre).getId();
            query = String.format("insert into albums_genre (id_album, id_genre) values (%d, %d) on conflict do nothing;", id_album, id_genre);
            genericQuery(query);
        }
    }

    public List<Genre> getGenres(int id) throws PropertyVetoException, SQLException {
        Connection con = Database.getConnection();
        List<Genre> genres = new ArrayList<>();
        String query = String.format("select id_genre from albums_genre where id_album = %d;", id);
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                genres.add(new Genre( rs.getInt(1), genreDAO.findById("genres", rs.getInt(1))));
            }
        }
        return genres;
    }

    public List<Album> findAll() throws SQLException, PropertyVetoException {
        List<Album> albums = new ArrayList<>();
        String query = "select id, release_year, title, artist_id from albums;";

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String artistName = artistDAO.findById("artists", rs.getInt(4));
                List<Genre> genres = getGenres(rs.getInt(1));
                albums.add(new Album(rs.getInt(1), rs.getInt(2), rs.getString(3), new Artist(rs.getInt(4), artistName), genres));
            }
        }
        return albums;
    }

    public Album findByTitle(String title) throws SQLException, PropertyVetoException {
        String query = String.format("select id, release_year, artist_id from albums where trim(title) = trim('%s');", title);
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                String artistName = artistDAO.findById("artists", rs.getInt(3));
                List<Genre> genres = getGenres(rs.getInt(1));
                return new Album(rs.getInt(1), rs.getInt(2), title, new Artist(rs.getInt(3), artistName), genres);
            }
        }
        return null;
    }

    public List<Album> findByReleaseYear(Integer releaseYear) throws SQLException, PropertyVetoException {
        List<Album> result = new ArrayList<>();
        String query = String.format("select id, title, artist_id from albums where release_year = %d;", releaseYear);

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String artistName = artistDAO.findById("artists", rs.getInt(3));
                List<Genre> genres = getGenres(rs.getInt(1));
                result.add(new Album(rs.getInt(1), releaseYear, rs.getString(2), new Artist(rs.getInt(3), artistName), genres));
            }
        }

        return result;
    }

    public List<Album> findByArtist(String artist) throws SQLException, PropertyVetoException {
        List<Album> result = new ArrayList<>();
        String query = String.format("select id, title, release_year from albums where artist_id = (select id from artists where trim(name) = trim('%s'));", artist);

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
               Artist artistObj = artistDAO.findByName(artist);
                List<Genre> genres = getGenres(rs.getInt(1));
                result.add(new Album(rs.getInt(1), rs.getInt(3), rs.getString(2), artistObj, genres));
            }
        }
        return result;
    }

    public List<Album> findByGenre(String genre) throws SQLException, PropertyVetoException {
        List<Album> result = new ArrayList<>();
        String query = String.format("select id, title, release_year, artist_id from albums join albums_genre on albums.id = albums_genre.id_album where albums_genre.id_genre = (select id from genres where trim(name) = trim('%s'));", genre);
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String artist = artistDAO.findById("artists", rs.getInt(4));
                Artist artistObj = artistDAO.findByName(artist);
                List<Genre> genres = getGenres(rs.getInt(1));
                result.add(new Album(rs.getInt(1), rs.getInt(3), rs.getString(2), artistObj, genres));
            }
        }
        return result;
    }

    public void updateTitle(String oldTitle, String newTitle) throws SQLException, PropertyVetoException {
        String query = String.format("update albums set trim(title) = trim('%s') where trim(title) = trim('%s');", newTitle, oldTitle);
        genericQuery(query);
    }

    public void updateReleaseYear(String title, Integer releaseYear) throws SQLException, PropertyVetoException {
        String query = String.format("update albums set releaseYear = %d where trim(title) = trim('%s');", releaseYear, title);
        genericQuery(query);
    }

    public void updateArtist(String title, String artist) throws SQLException, PropertyVetoException {
        Integer id = artistDAO.findByName(artist).getId();
        String query = String.format("update albums set artist_id = %d where trim(title) = trim('%s');", id, title);
        genericQuery(query);
    }

    public void updateGenres(String title, List<String> genres) throws SQLException, PropertyVetoException {
        /* delete all entries about this specific album from albums_genre and insert new ones based on parameters */
        Integer id = findByTitle(title).getId();
        String query = String.format("delete from albums_genre where id_album = %d;", id);
        genericQuery(query);
        for (String genre : genres) {
            Integer id_genre = genreDAO.findByName(genre).getId();
            query = String.format("insert into albums_genre (id_album, id_genre) values(%d, %d);", id, id_genre);
            genericQuery(query);
        }
    }

    public void deleteByTitle(String title) throws SQLException, PropertyVetoException {
        String query = String.format("delete from albums where trim(title) = trim('%s');", title);
        genericQuery(query);
    }

    public void deleteByReleaseYear(Integer year) throws SQLException, PropertyVetoException {
        String query = String.format("delete from albums where release_year = %d;", year);
        genericQuery(query);
    }

    public void deleteByArtist(String artist) throws SQLException, PropertyVetoException {
        Integer id = artistDAO.findByName(artist).getId();
        String query = String.format("delete from albums where artist_id = %d;", id);
        genericQuery(query);
    }

    public void deleteByGenre(String genre) throws SQLException, PropertyVetoException {
        /* delete from albums but also from albums_genre */
        Integer id = genreDAO.findByName(genre).getId();
        String query = String.format("select id_album from albums_genre where id_genre = %d;", id);

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }
        query = String.format("delete from albums where id = %d;", id);
        genericQuery(query);

        query = String.format("delete from albums_genre where id_album = %d;", id);
        genericQuery(query);
    }
}
