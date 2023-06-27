package com.cyc.collectyourcollections.database;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String author;

    @ElementCollection
    private Set<String> genresList;

    public BookEntity(String title, String author, Set<String> genresList) {
        this.title = title;
        this.author = author;
        this.genresList = genresList;
    }

    public Long getId() {
        return id;
    }

    public BookEntity(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Set<String> getGenresList() {
        return genresList;
    }

    public void setGenresList(Set<String> genresList) {
        this.genresList = genresList;
    }
}
