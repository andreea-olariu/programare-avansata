package org.example.cat;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll",
                query = "select e from Genre e"),
        @NamedQuery(name = "Genre.findById",
                query = "select e from Genre e where e.id = ?1"),
        @NamedQuery(name = "Genre.findByTitle",
                query = "select e from Genre e where e.name = ?1"),
})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Genre() {

    }

    public Genre(String name) {
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

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
