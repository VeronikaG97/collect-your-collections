package com.cyc.collectyourcollections.data;

import java.util.List;

public class Book extends Item {

    public Book(String title, Creator creator, List<String> genre) {
        super(title, creator, genre);
    }
}