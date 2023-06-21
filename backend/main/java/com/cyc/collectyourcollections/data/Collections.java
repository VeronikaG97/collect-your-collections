package com.cyc.collectyourcollections.data;

import com.cyc.collectyourcollections.exceptions.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Collections {
    private List<Item> collections = new ArrayList<>();

    public Collections(List<Item> collections) {
        this.collections = collections;
    }

    public List<Item> getCollections() {
        return collections;
    }

    public void setCollections(List<Item> collections) {
        this.collections = collections;
    }

    public void addBook (Book book) {
        collections.add(book);
    }

    public Book updateBook(String title, Book book) throws BookNotFoundException {
        collections.stream()
                .filter(bookInList ->  bookInList.getTitle().equals(title))
                .findFirst()
                .map(bookToUpdate -> collections.remove(bookToUpdate))
                .orElseThrow(() -> new BookNotFoundException(title));

        collections.add(book);
        return book;
    }

    public void deleteBook(String title) throws BookNotFoundException {
        collections.stream()
                .filter(bookInList -> bookInList.getTitle().equals(title))
                .findFirst()
                .map(bookToDelete -> collections.remove(bookToDelete))
                .orElseThrow(() -> new BookNotFoundException(title));
    }
}
