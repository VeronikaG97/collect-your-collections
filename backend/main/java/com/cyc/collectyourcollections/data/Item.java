package com.cyc.collectyourcollections.data;

import java.util.List;
import java.util.Set;

public abstract class Item {
    private final String title;
    private final String creator;
    private Set<String> genre;

    public Item(String title, String creator, Set<String> genre) {
        this.title = title;
        this.creator = creator;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public Set<String> getGenre() {
        return genre;
    }

    public void setGenre(Set <String> genre) {
        this.genre = genre;
    }
}
