package com.cyc.collectyourcollections.database;

import com.cyc.collectyourcollections.data.BookGenres;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class BookCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String author;
    private List<BookGenres> genresList;

    public BookCollection(String title, String author, List<BookGenres> genresList) {
        this.title = title;
        this.author = author;
        this.genresList = genresList;
    }

    public BookCollection(){}

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

    public List<BookGenres> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<BookGenres> genresList) {
        this.genresList = genresList;
    }
}
