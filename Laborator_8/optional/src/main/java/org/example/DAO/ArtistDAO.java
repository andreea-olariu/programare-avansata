package org.example.DAO;

import org.example.Database;
import org.example.Models.Artist;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ArtistDAO extends EntityDAO {

    /* order of params: name */
    public void create(Object... params) throws SQLException, PropertyVetoException {
        String query = String.format("insert into artists (name) values (trim('%s')) on conflict do nothing;", params[0]);
        genericQuery(query);
    }

    public List<Artist> findAll() throws SQLException, PropertyVetoException {
        List<Artist> artists = new ArrayList<>();
        String query = "select id, name from artists;";
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Artist artist = new Artist(rs.getInt(1), rs.getString(2));
                artists.add(artist);
            }
        }
        return artists;
    }

    public Artist findByName(String name) throws SQLException, PropertyVetoException {
        String query = String.format("select id from artists where trim(name) = trim('%s');", name);
        Integer id = null;
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            if(rs.next()) {
                id = rs.getInt(1);
            }
        }
        return new Artist(id, name);
    }

    public void updateName(String oldName, String newName) throws SQLException, PropertyVetoException {
        String query = String.format("update artists set trim(name) = trim('%s') where trim(name) = trim('%s');", newName, oldName);
        genericQuery(query);
    }

    public void deleteByName(String name) throws SQLException, PropertyVetoException {
        String query = String.format("delete from artists where trim(name) = trim('%s');", name);
        genericQuery(query);
    }
}