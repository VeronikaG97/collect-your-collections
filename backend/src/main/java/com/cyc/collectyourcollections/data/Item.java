package com.cyc.collectyourcollections.data;

import java.util.ArrayList;

public abstract class Item {
    private final String title;
    private final Creator creator;
    private ArrayList<String> genre = new ArrayList<String>();

    public Item(String title, Creator creator, ArrayList<String> genre) {
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

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }
}
