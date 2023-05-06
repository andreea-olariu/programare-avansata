package org.example.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
                query = "select e from Artist e"),
        @NamedQuery(name = "Artist.findById",
                query = "select e from Artist e where e.id = ?1"),
        @NamedQuery(name = "Artist.findByTitle",
                query = "select e from Artist e where e.name = ?1"),
})
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Artist() {

    }

    public Artist(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
