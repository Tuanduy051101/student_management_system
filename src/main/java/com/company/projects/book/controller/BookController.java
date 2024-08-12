package com.company.projects.book.controller;

import com.company.projects.bookmanagement.entity.Book;
import com.company.projects.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Page<Book> getAllBooks(@RequestParam int page, @RequestParam int size) {
        return bookService.getAllBooks(page, size);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) Long id) {
        return bookService.searchBooks(title, id);
    }

    @GetMapping("/date-range")
    public List<Book> findBooksByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return bookService.findBooksByDateRange(startDate, endDate);
    }

    @GetMapping("/sort-by-price")
    public List<Book> sortBooksByPrice() {
        return bookService.sortBooksByPrice();
    }

    @GetMapping("/sort-by-quantity-sold")
    public List<Book> sortBooksByQuantitySold() {
        return bookService.sortBooksByQuantitySold();
    }

    @GetMapping("/top-5-best-sellers")
    public List<Book> getTop5BestSellers() {
        return bookService.getTop5BestSellers();
    }

    @GetMapping("/total-books-sold")
    public long getTotalBooksSold() {
        return bookService.getTotalBooksSold();
    }
}
