package com.bookmanager.bookmanager.Service;

import com.bookmanager.bookmanager.Entity.Book;
import com.bookmanager.bookmanager.Entity.User;
import java.util.List;
public interface UserService {
    User findByUsername(String username);
    User createUser(User user);
    User getUserById(Integer id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Integer id);
    User addBook(int bookId, int userId);
    User deleteBook(int bookId,int userId);
    List<Book> getBooksOfUser(int userId);
} 