package com.cyc.collectyourcollections.data;

import java.util.List;
import java.util.Set;

public class Book extends Item {
    public Book(String title, String creator, Set<String> genre) {
        super(title, creator, genre);
    }
}