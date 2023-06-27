package com.cyc.collectyourcollections.restController;

import com.cyc.collectyourcollections.data.Book;
import com.cyc.collectyourcollections.data.Collections;
import com.cyc.collectyourcollections.database.BookCollectionRepository;
import com.cyc.collectyourcollections.database.BookEntity;
import com.cyc.collectyourcollections.exceptions.BookNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
@RequestMapping("collections/books")
public class endpointBook {
    private final Collections collections;
    private final BookCollectionRepository  bookCollectionRepository;

    public endpointBook(Collections collections, BookCollectionRepository bookCollectionRepository) {
        this.collections = collections;
        this.bookCollectionRepository = bookCollectionRepository;
    }

    @GetMapping("/all-books")
    public List<BookEntity> getAllBooks(){
        return bookCollectionRepository.findAll();
    }

    @PostMapping("/add-book")
    public Long addABook(@RequestBody Book book){
        BookEntity bookToSave = new BookEntity(
                book.getTitle(),
                book.getCreator(),
                book.getGenre()
        );
        bookCollectionRepository.save(bookToSave);
        return bookToSave.getId();
    }

    @PatchMapping("/update-book/{title}")
    public Book deleteBook(@PathVariable String title, @RequestBody Book book) throws BookNotFoundException {
        collections.updateBook(title, book);
        return book;
    }

    @DeleteMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable long id) throws BookNotFoundException {
        try {
            bookCollectionRepository.deleteById(id);
        } catch (Exception e) {
            return "Book was not found.";
        }
        return String.format("The book is removed.");
    }
}
