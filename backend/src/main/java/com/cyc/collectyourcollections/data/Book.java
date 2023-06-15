package com.cyc.collectyourcollections.data;

import java.util.ArrayList;

public class Book extends Item {
    public Book(String title, Creator creator, ArrayList<String> genre) {
        super(title, creator, genre);
    }
}