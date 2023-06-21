package com.cyc.collectyourcollections.restController;

import com.cyc.collectyourcollections.data.Book;
import com.cyc.collectyourcollections.data.Collections;
import com.cyc.collectyourcollections.data.Item;
import com.cyc.collectyourcollections.database.BookCollection;
import com.cyc.collectyourcollections.database.BookCollectionRepository;
import com.cyc.collectyourcollections.exceptions.BookNotFoundException;
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
        return collections.getCollections();
    }

    @PostMapping("/add-book")
    public Book addABook(@RequestBody Book book){
        collections.addBook(book);
        return book;
    }

    @PatchMapping("/update-book/{title}")
    public Book updateBook(@PathVariable String title, @RequestBody Book book) throws BookNotFoundException {
        collections.updateBook(title, book);
        return book;
    }

    @DeleteMapping("delete-book/{title}")
    public String updateBook(@PathVariable String title) throws BookNotFoundException {
        collections.deleteBook(title);
        return String.format("The book %s is removed.", title);
        //return "The Book" + title + "is removed"
    }
}
