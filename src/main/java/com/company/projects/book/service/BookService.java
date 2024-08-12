package com.company.projects.book.service;

import com.company.projects.bookmanagement.entity.Book;
import com.company.projects.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String title, Long id) {
        return bookRepository.findByTitleContainingOrId(title, id);
    }

    public List<Book> findBooksByDateRange(Date startDate, Date endDate) {
        return bookRepository.findByDateAddedBetween(startDate, endDate);
    }

    public List<Book> sortBooksByPrice() {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    public List<Book> sortBooksByQuantitySold() {
    }

    public List<Book> getTop5BestSellers() {
    }

    public long getTotalBooksSold() {
    }
}
