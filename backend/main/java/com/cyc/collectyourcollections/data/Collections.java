package com.cyc.collectyourcollections.data;

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
}
