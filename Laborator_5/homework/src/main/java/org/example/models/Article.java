package org.example.models;

public class Article extends Document {
    private String newsWebsite;

    public Article(String path, int id, String name, String newsWebsite) {
        super(path, id, name);
        this.newsWebsite = newsWebsite;
    }
}
