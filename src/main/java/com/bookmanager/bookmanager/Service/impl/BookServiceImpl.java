package com.bookmanager.bookmanager.Service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.bookmanager.Entity.Book;
import com.bookmanager.bookmanager.Service.BookService;
import com.bookmanager.bookmanager.exception.ResourceNotFoundException;
import com.bookmanager.bookmanager.repository.BookRepository;

@Service

public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;


    public Book createBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }
    public Book getBookById(Integer bookId)
    {
        Book book=bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book is not exist with given id:"+bookId));
        return book;
    }

    public List<Book> findAllBooks(){
        
        return bookRepository.findAll();
    }
    @Override
    public Book updateBook(Integer bookId, Book updateBook) {
       Book book= bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book is not exist with given id:"+bookId));
       book.setName(updateBook.getName());
       book.setAuthor(updateBook.getAuthor());
       book.setPrice(updateBook.getPrice());
       return bookRepository.save(book);
       
    }
    public void deleteById(Integer bookId){
         bookRepository.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book is not exist with given id:"+bookId));
        bookRepository.deleteById(bookId);
    }


}
