package com.cyc.collectyourcollections.data;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Book book1 = new Book(
                book.getTitle(),
                book.getCreator(),
                book.getGenre()
        );
        collections.add(book);
    }
}
