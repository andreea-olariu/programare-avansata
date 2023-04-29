package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/music";
    private static Connection connection = null;
    private static ComboPooledDataSource pool = null;

    private Database() {
    }

    public static Connection getConnection() throws PropertyVetoException, SQLException {
        if(connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createPool() throws PropertyVetoException {
        pool = new ComboPooledDataSource();
        pool.setDriverClass("org.postgresql.Driver");
        pool.setJdbcUrl(URL);
    }

    private static void createConnection() throws SQLException, PropertyVetoException {
        if(pool == null) {
            createPool();
        }
        connection = pool.getConnection();
        connection.setAutoCommit(false);
    }

    public static void closeConnection() {
        pool.close();
    }

    public static void rollback(Savepoint savePoint) {
        try {
            connection.rollback(savePoint);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
