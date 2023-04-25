package org.example;

import org.postgresql.util.PSQLException;

import java.sql.*;

public class ArtistDAO {

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Integer result;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from artists where name='" + name + "'")) {
            result = rs.next() ? rs.getInt(1) : null;
        }
        return result;
    }

    public String findById(int id) throws SQLException {
        String result;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from artists where id = " + id)) {
            result = rs.next() ? rs.getString(1) : null;
        }
        return result;
    }

    public void updateName(String oldName, String newName) throws SQLException, PSQLException  {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("update artists set name = '" + newName + "' where name = '" + oldName + "'")) {
            pstmt.executeUpdate();
        }
    }

    public void deleteByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("delete from artists where name = '" + name + "'")) {
            pstmt.executeUpdate();
            }
        }
}