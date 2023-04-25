package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ArtistDAO artistDAO = new ArtistDAO();
        artistDAO.create("Alternosfera");
        artistDAO.create("Thirty seconds to mars");
        Integer id = artistDAO.findByName("Alternosfera");
        artistDAO.deleteByName("Thirty seconds to mars");
        System.out.println(artistDAO.findById(id));
        artistDAO.updateName("Alternosfera", "Tamino");
        Database.closeConnection();
    }
}