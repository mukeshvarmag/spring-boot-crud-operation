package com.javatpoint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.javatpoint.model.Books;
import com.javatpoint.service.BooksService;

@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    BooksService booksService;

    // Retrieve all books
    @GetMapping("/books")
    private List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    // Retrieve a specific book by ID
    @GetMapping("/book/id/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid) {
        return booksService.getBooksById(bookid);
    }

    // Retrieve books by name
    @GetMapping("/books/name/{bookName}")
    private List<Books> getBooksByName(@PathVariable("bookName") String bookName) {
        return (List<Books>) booksService.getBooksByName(bookName);
    }

    // Retrieve books by author
    @GetMapping("/books/author/{author}")
    private List<Books> getBooksByAuthor(@PathVariable("author") String author) {
        return (List<Books>) booksService.getBooksByAuthor(author);
    }

    // Retrieve the total price of all books
    @GetMapping("/books/totalPrice")
    private int getTotalPrice() {
        return booksService.getSumOfPrices();
    }

    // Delete a book by ID
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) {
        booksService.delete(bookid);
    }

    // Save a new book
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }

    // Update an existing book
    @PutMapping("/books")
    private Books update(@RequestBody Books books) {
        booksService.update(books);
        return books;
    }
}
