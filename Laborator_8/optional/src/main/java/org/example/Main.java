package org.example;

import com.opencsv.exceptions.CsvException;
import org.example.DAO.AlbumDAO;
import org.example.DAO.ArtistDAO;
import org.example.DAO.GenreDAO;
import org.example.Models.Genre;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, PropertyVetoException, IOException, CsvException {
//        ArtistDAO artists = new ArtistDAO();
//
//        artists.create("Alternosfera");
//        artists.create("Michael Jackson");
//        artists.create("Prince");
//
//        int id1 = artists.findByName("Alternosfera").getId();
//        artists.updateName("Alternosfera", "The Weeknd");
//        artists.deleteByName("The Weeknd");
//
        GenreDAO genreDAO = new GenreDAO();
//        genres.create("Punk");
//        genres.create("Funk");
//        genres.create("Soul");
//        genres.create("Pop");
//        genres.create("Jazz");
//        genres.create("Rock");
//        int id2 = genres.findByName("Rock").getId();
//
//        albums.create("Thriller", 1982, "Michael Jackson", List.of("Funk", "Soul", "Pop"));
//        Integer id3 = albums.findByTitle("Thriller").getId();
//        List<Integer> foundAlbums = new ArrayList<>();
//        albums.findByReleaseYear(1982).stream().map(Entity::getId).forEach(foundAlbums::add);
//        foundAlbums = albums.findByArtist("Michael Jackson");
//        foundAlbums = albums.findByGenre("Pop");
//        albums.updateArtist("Thriller", "Prince");
//        albums.updateGenres("Thriller", List.of("Jazz", "Rock"));
//        albums.updateTitle("Thriller", "Ok");
//        albums.deleteByArtist("Prince");
//        albums.deleteByGenre("Rock");
//        Database.closeConnection();


        Savepoint savePoint = Database.getConnection().setSavepoint();

        AlbumDAO albumDAO = new AlbumDAO();
        DataManipulationTool tool = new DataManipulationTool();
        List<String[]> albums = tool.read();
//        tool.print();
        for(String[] album : albums) {
            List<String> albumGenres = List.of(album[4].split(",|&|/"));
            List<String> newAlbumGenres = new ArrayList<>();
            for(int i = 0; i < albumGenres.size(); i++) {
                String name = tool.genreName(albumGenres.get(i));
                if(!name.equals(""))
                    newAlbumGenres.add(name);
            }
            albumDAO.create(album[2], album[1], album[3], newAlbumGenres);
        }

        List<Genre> genres = genreDAO.findAll();
        genres.stream().forEach(System.out::println);

        Database.closeConnection();
        Database.rollback(savePoint);
    }
}