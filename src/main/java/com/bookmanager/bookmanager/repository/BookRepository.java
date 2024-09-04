package com.bookmanager.bookmanager.repository;
import com.bookmanager.bookmanager.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;;
public interface BookRepository extends JpaRepository<Book,Integer> {
    
}
