package com.cyc.collectyourcollections.restController;

import com.cyc.collectyourcollections.data.Book;
import com.cyc.collectyourcollections.data.Collections;
import com.cyc.collectyourcollections.data.Item;
import com.cyc.collectyourcollections.database.BookCollection;
import com.cyc.collectyourcollections.database.BookCollectionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collections/books")
public class endpointBook {
    private Collections collections;
    private final BookCollectionRepository  bookCollectionRepository;

    public endpointBook(Collections collections, BookCollectionRepository bookCollectionRepository) {
        this.collections = collections;
        this.bookCollectionRepository = bookCollectionRepository;
    }

    @GetMapping("/all-books")
    public List<Item> getAllBooks(){
        System.out.println("Hello from all-books endpoint");
        return collections.getCollections();
    }

    @PostMapping("/add-book")
    public Book addABook(@RequestBody Book book){
        System.out.println("Hello from add-book endpoint");
        collections.addBook(book);
        return book;
    }
}
