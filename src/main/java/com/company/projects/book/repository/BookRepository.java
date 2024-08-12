package com.company.projects.book.repository;

import com.company.projects.bookmanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrId(String title, Long id);
    List<Book> findByDateAddedBetween(Date startDate, Date endDate);
}
