package com.cyc.collectyourcollections.exceptions;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(String title) {
        super(title);
    }
}
