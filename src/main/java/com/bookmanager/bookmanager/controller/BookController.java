package com.bookmanager.bookmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookmanager.bookmanager.Entity.Book;
import com.bookmanager.bookmanager.Service.BookService;

import lombok.AllArgsConstructor;
import lombok.Getter;import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/api/book")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping("/getall")
    public ResponseEntity<List<Book>> getBookById(){
    
    return ResponseEntity.ok(bookService.findAllBooks());
    }
    //build add book rest api
    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book savedbook = bookService.createBook(book);
        return new ResponseEntity<>(savedbook, HttpStatus.CREATED);
    }
    //build get book rest api
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer bookId){
    Book bookDto=bookService.getBookById(bookId);
    return ResponseEntity.ok(bookDto);
    }
    // build update book rest api
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer bookId,@RequestBody Book updateBook){
        
        return ResponseEntity.ok(bookService.updateBook(bookId, updateBook));
    }
    //build detele using rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id")Integer bookId){
        bookService.deleteById(bookId);
        return ResponseEntity.ok("deteled book"+bookId);
    }


}
