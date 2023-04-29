package org.example.DAO;

import org.example.Database;
import org.example.Models.Genre;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO extends EntityDAO {

    /* order of params: name */
    public void create(Object... params) throws SQLException, PropertyVetoException {
        String query = String.format("insert into genres (name) values (trim('%s')) on conflict do nothing;", params[0]);
        genericQuery(query);
    }

    public List<Genre> findAll() throws SQLException, PropertyVetoException {
        List<Genre> genres = new ArrayList<>();
        String query = "select id, name from genres;";
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Genre genre = new Genre(rs.getInt(1), rs.getString(2));
                genres.add(genre);
            }
        }
        return genres;
    }

    public Genre findByName(String name) throws SQLException, PropertyVetoException {
        String query = String.format("select id from genres where trim(name) = trim('%s');", name);
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return new Genre(rs.getInt(1), name);
            }
        }
        return null;
    }

    public void updateName(String oldName, String newName) throws SQLException, PropertyVetoException {
        String query = String.format("update genres set name = trim('%s') where trim(name) = trim('%s');", newName, oldName);
        genericQuery(query);
    }

    public void deleteByName(String name) throws SQLException, PropertyVetoException {
        /* delete also from albums_genre */
        String query = String.format("delete from genres where trim(name) = trim('%s');", name);
        genericQuery(query);

        Integer id = findByName(name).getId();
        query = String.format("delete from albums_genre where id_genre = %d;", id);
        genericQuery(query);
    }

}
