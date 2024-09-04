package com.bookmanager.bookmanager.Service;

import java.util.List;

import com.bookmanager.bookmanager.Entity.Book;


public interface BookService {

    Book createBook(Book bookDto);
    Book getBookById(Integer bookId);
    List<Book> findAllBooks();
    Book updateBook(Integer bookId,Book updateBook);
    void deleteById(Integer bookId);

    
} 
