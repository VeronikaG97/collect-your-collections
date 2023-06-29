package com.cyc.collectyourcollections.restController;

import com.cyc.collectyourcollections.data.Book;
import com.cyc.collectyourcollections.data.BookGenres;
import com.cyc.collectyourcollections.data.Collections;
import com.cyc.collectyourcollections.database.BookCollectionRepository;
import com.cyc.collectyourcollections.database.BookEntity;
import com.cyc.collectyourcollections.exceptions.BookNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping("/all-genres")
    public List<BookGenres> getAllGenres(){
        List<BookGenres> listOfGenres = Arrays.asList(BookGenres.values());
        return listOfGenres;
    }

    @PostMapping("/add-book")
    public Long addABook(@RequestBody Book book){
        BookEntity bookToSave = getNewBookEntity(book);
        bookCollectionRepository.save(bookToSave);
        return bookToSave.getId();
    }

    @PatchMapping("/update-book/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) throws BookNotFoundException {
        bookCollectionRepository.deleteById(id);
        BookEntity bookToUpdate = getNewBookEntity(book);
        bookCollectionRepository.save(bookToUpdate);
        return book;
    }

    @DeleteMapping("/delete-book/{id}")
    public void deleteBook(@PathVariable long id) throws BookNotFoundException {
        bookCollectionRepository.deleteById(id);
    }

    private static BookEntity getNewBookEntity(Book book) {
        BookEntity bookToSave = new BookEntity(
                book.getTitle(),
                book.getCreator(),
                book.getGenre()
        );
        return bookToSave;
    }
}
