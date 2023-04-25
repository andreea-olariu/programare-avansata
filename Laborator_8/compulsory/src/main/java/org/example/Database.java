package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/music";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        if(connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println(e);
            try {
                connection.setAutoCommit(false);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
