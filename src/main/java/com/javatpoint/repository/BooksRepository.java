package com.javatpoint.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.javatpoint.model.Books;

import java.util.List;

//repository that extends CrudRepository
public interface BooksRepository extends JpaRepository<Books, Integer>
{
    List<Books> findById(int id);

    List<Books> findByBookname(String bookname);

    // Find books by the author's name
    List<Books> findByAuthor(String author);
}