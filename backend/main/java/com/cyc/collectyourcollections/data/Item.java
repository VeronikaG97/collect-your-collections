package com.cyc.collectyourcollections.data;

import java.util.List;

public abstract class Item {
    private final String title;
    private final Creator creator;
    private List<String> genre;

    public Item(String title, Creator creator, List<String> genre) {
        this.title = title;
        this.creator = creator;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Creator getCreator() {
        return creator;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List <String> genre) {
        this.genre = genre;
    }
}
