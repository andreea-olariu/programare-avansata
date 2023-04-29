package org.example.DAO;

import org.example.Database;
import org.example.Models.Genre;

import java.beans.PropertyVetoException;
import java.sql.*;

public abstract class EntityDAO {

    public void genericQuery(String query) throws SQLException, PropertyVetoException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.execute();
        }
    }

    public String findById(String tableName, int id) throws SQLException, PropertyVetoException {
        String query = String.format("select name from %s where id = %d", tableName, id);

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString(1);
            }
        }
        return null;
    }

    public abstract void create(Object... params) throws SQLException, PropertyVetoException;
}
