package org.example.models;

public class Book extends Document {

    private String genre;

    public Book(String path, int id, String name, String genre) {
        super(path, id, name);
        this.genre = genre;
    }
}
