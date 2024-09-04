package com.bookmanager.bookmanager.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.bookmanager.Entity.Book;
import com.bookmanager.bookmanager.Entity.User;
import com.bookmanager.bookmanager.Service.BookService;
import com.bookmanager.bookmanager.Service.UserService;
import com.bookmanager.bookmanager.exception.ResourceNotFoundException;
import com.bookmanager.bookmanager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookService bookService;

    public User createUser(User user){
        System.out.println(user);
        return userRepository.save(user);
    }
    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id is not found"+id));
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User updateUser(User user) {

        if(!userRepository.findById(user.getUserId()).isEmpty()) 
            return userRepository.save(user);
        throw new UnsupportedOperationException("user not found");
    }
    @Override
    public void deleteUser(Integer id) {
        // TODO Auto-generated method stub
        userRepository.deleteById(id);
    }
    @Override
    public User addBook(int bookId, int userId) {
        User user = getUserById(userId);
        Book book = bookService.getBookById(bookId);
        user.getBooks().add(book);
        return userRepository.save(user);
    }

    @Override
    public User deleteBook(int bookId, int userId) {
        User user=getUserById(userId);
        List<Book> t = user.getBooks();
        t=t.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
        user.setBooks(t);
        return userRepository.save(user);
    }
    @Override
    public List<Book> getBooksOfUser(int userId) {
        User user = getUserById(userId);
        return user.getBooks();
    }
}
