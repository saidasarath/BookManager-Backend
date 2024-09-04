package com.bookmanager.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanager.bookmanager.Entity.Book;
import com.bookmanager.bookmanager.Entity.User;
import com.bookmanager.bookmanager.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
    @GetMapping("/{id}")
   public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
    return ResponseEntity.ok(userService.getUserById(id));
   }
   @GetMapping("/getallusers")
   public ResponseEntity<List<User>> getAllUsers(){
    return ResponseEntity.ok(userService.getAllUsers());
   }
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("deleted user");
    }

    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<User> borrowBook(@PathVariable("bookId") Integer bookId, @PathVariable("userId") int userId){
        return new ResponseEntity<>(userService.addBook(bookId, userId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{userId}/{bookId}")
    public ResponseEntity<User> deleteBook(@PathVariable("bookId") Integer bookId, @PathVariable("userId") int userId){
        return ResponseEntity.ok(userService.deleteBook(bookId, userId));
    }
    @GetMapping("/get/{userId}")
    public ResponseEntity<List<Book>> getbookbyuserid(@PathVariable("userId") int userId)
{
    return ResponseEntity.ok(userService.getBooksOfUser(userId));
}
}
